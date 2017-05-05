
package fv.monster.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fvsaddam - saddamtbg@gmail.com
 */
@RestController
public class IndexController {
    
    @GetMapping("/nama")
    public String namaku(@RequestParam(value="id", defaultValue="fvSaddam") String id, ModelMap mm) {
        mm.addAttribute("nama", id);
        return "index: " + id;
    }

}
