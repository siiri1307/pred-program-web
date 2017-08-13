package siir.saar.veeb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import predmoodul.Kontroll;
import predmoodul.erindid.AbiValemEiOleDefineeritud;
import predmoodul.erindid.ErinevIndiviidideArv;
import predmoodul.erindid.SyntaksiViga;
import predmoodul.erindid.VaarVabadeMuutujateEsinemine;

import java.io.IOException;
import java.util.List;

@Controller
public class YlesandeController {

  Pakkumine tudengiPakkumine;

  @RequestMapping(method = RequestMethod.GET, value = "/ylesanded/{number}")
  public String naitaYlesannet(@PathVariable String number, Model model) {

    List<Ylesanne> ylesanded = Main.getYlesanded();

    model.addAttribute("yl", ylesanded.get(Integer.parseInt(number)-1));
    model.addAttribute("pakkumine", new Pakkumine());
    model.addAttribute("tulemus", "");

    return "ylesanne";
  }

  @RequestMapping(method = RequestMethod.POST, value = "/ylesanded/{number}")
  public String kontrolliLahendust(@ModelAttribute Pakkumine pakkumine, @PathVariable String number, Model model) throws VaarVabadeMuutujateEsinemine, AbiValemEiOleDefineeritud, SyntaksiViga, IOException, ErinevIndiviidideArv {

    tudengiPakkumine = pakkumine;

    List<Ylesanne> ylesanded = Main.getYlesanded();

    String tudengiVastus = pakkumine.getLahendus();
    String oigeVastus = ylesanded.get(Integer.parseInt(number)-1).getLahendus();
    String kontrollimiseTulemus = "";

    try{
      Kontroll kontroll = new Kontroll(tudengiVastus, oigeVastus);
      int kasOige = kontroll.getKontrolliTulemus();
      if(kasOige == 0){
        kontrollimiseTulemus = "Sinu valem ei ole õige. " + kontroll.kontraNaideStringina();
      }
      else if(kasOige == 1){
        kontrollimiseTulemus = "Sinu valem on õige.";
      }
      else if(kasOige == 3){
        kontrollimiseTulemus = "Sinu valem võib olla õige.";
      }
    }
    catch(ErinevIndiviidideArv viga){
      kontrollimiseTulemus = viga.getMessage();
    }
    catch(VaarVabadeMuutujateEsinemine viga){
      kontrollimiseTulemus = viga.getMessage();
    }
    catch(SyntaksiViga viga){
      kontrollimiseTulemus = viga.getMessage();
    }

    model.addAttribute("yl", ylesanded.get(Integer.parseInt(number)-1));
    model.addAttribute("pakkumine", tudengiPakkumine);
    model.addAttribute("tulemus", kontrollimiseTulemus);

    return "ylesanne";
  }

}
