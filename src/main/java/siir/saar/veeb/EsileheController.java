package siir.saar.veeb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
public class EsileheController {

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String getYlesanded(@RequestParam(value = "", required = false, defaultValue = "") String yl, Model model) throws SQLException, ClassNotFoundException {

	model.addAttribute("ylesanded", Main.getYlesanded());

	return "ylesanded";
  }
}
