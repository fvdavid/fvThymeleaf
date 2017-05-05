
package fv.monster.controller;

import fv.monster.model.Materi;
import fv.monster.repository.MateriRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author fvsaddam - saddamtbg@gmail.com
 */
@Controller
@RequestMapping("/materi")
public class MateriController {
    
    @Autowired
    private MateriRepository materiRepository;
    
    @GetMapping("list")
    public ModelMap daftarMateri(Pageable page) {
        ModelMap mm = new ModelMap();
        mm.addAttribute("daftarMateri", materiRepository.findAll(page));
        return mm;
    }
    
    @GetMapping("form")
    public String materiBaru(Materi m) {
        return "materi/form";
    }
    
    @PostMapping("form")
    public String prosesForm(@ModelAttribute @Valid Materi m, BindingResult hasilValidasi) {
        
        if(hasilValidasi.hasErrors()) {
            return "materi/form";
        }
        materiRepository.save(m);
        
        return "redirect:list";
    }
    
    @PostMapping("/shared")
    public String prosesSharedForm(@ModelAttribute @Valid Materi m, BindingResult hasilValidasi,
            @RequestParam("idChecked") List<Long> values) throws Exception {
        
        // setelah di checkbox kemudian di klik share, maka ter-update column shareto menjadi 'ADMIN'
        
        // mendapatkan semua ids dari column yg ingin di update
        System.out.println("output list id ---> " + values);
        
        values.forEach((id) -> {
           System.out.println("output id ---> " + id);
           
           materiRepository.getMateriById(id);
           m.setId(id);
           m.setShareto("admin-fv");
           materiRepository.save(m);
        });
        
//        long i = 0;
//        while(i < values.size()) {
//            
//            System.out.println("----> : " + values.get((int) i));
//            System.out.println("iiii : " + i);
//            md.getMateriById(values.get(i));
//            i++;
            
//            md.getMateriById(i);
//            m.setId(i);
//            m.setShareto("admin-fv");
//            md.save(m);

//            System.out.println("output ---> " + values.size());
//            System.out.println("i: " + i);
            
//        }

//        Iterator<String> iterator = values.get((long) i);
//        while(iterator.hasNext()) {
//            m.setShareto("admin-fv");
//            md.save(m);
//        }


        return "redirect:/materi/list";
    }

}
