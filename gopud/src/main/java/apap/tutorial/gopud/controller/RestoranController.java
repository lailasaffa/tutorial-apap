package apap.tutorial.gopud.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import apap.tutorial.gopud.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.service.RestoranService;

@Controller
public class RestoranController{
    @Qualifier("restoranServiceImpl")
    @Autowired
    private RestoranService restoranService;
    @Autowired
    private MenuService menuService;

    @RequestMapping(value="/")
    public String home(){
        return "home";
    }

//    @RequestMapping("/restoran/add")
//    public String add(
//            @RequestParam(value = "idRestoran", required = true) Long idRestoran,
//            @RequestParam(value = "nama", required = true) String nama,
//            @RequestParam(value = "alamat", required = true) String alamat,
//            @RequestParam(value = "nomorTelepon", required = true) Integer nomorTelepon,
//            Model model
//    ){
//        RestoranModel restoran = new RestoranModel(idRestoran,nama,alamat,nomorTelepon);
//
//        restoranService.addRestoran(restoran);
//
//        model.addAttribute("namaResto",nama);
//
//        return "add-restoran";
//    }

    //URL mapping untuk mengakses halaman add restoran tutorial 3
    @RequestMapping(value = "/restoran/add",method = RequestMethod.GET)
    public String addRestoranFormPage(Model model){
        RestoranModel newRestoran = new RestoranModel();
        model.addAttribute("restoran",newRestoran);
        return "form-add-restoran";
    }

    //URL mapping untuk submit form yang telah dimasukkan pada halaman add restoran
    @RequestMapping(value = "/restoran/add", method = RequestMethod.POST)
    public String addRestoranSubmit(@ModelAttribute RestoranModel restoran, Model model){
        restoranService.addRestoran(restoran);
        model.addAttribute("namaResto",restoran.getNama());
        return "add-restoran";
    }

    @RequestMapping(value = "/restoran/view",method = RequestMethod.GET)
    public String view(
            //Request parameter untuk dipass
            @RequestParam(value="idRestoran") Long idRestoran, Model model
    ){
        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran).get();
        model.addAttribute("resto",restoran);
        List<MenuModel> menuList = menuService.findAllMenuByIdRestoran(restoran.getIdRestoran());
        model.addAttribute("menuList",menuList);

        return "view-restoran";
    }

    //API untuk menuju halaman form change restoran
    @RequestMapping(value = "restoran/change/{idRestoran}",method = RequestMethod.GET)
    public String changeRestoranFormPage(@PathVariable Long idRestoran, Model model){
        RestoranModel existingRestoran = restoranService.getRestoranByIdRestoran(idRestoran).get();
        model.addAttribute("restoran",existingRestoran);
        return "form-change-restoran";
    }

    @RequestMapping(value = "restoran/change/{idRestoran}",method = RequestMethod.POST)
    public String changeRestoranFormSubmit(
            @PathVariable Long idRestoran,
            @ModelAttribute RestoranModel restoran,
            Model model
    ){
        RestoranModel newRestoranData = restoranService.changeRestoran(restoran);
        model.addAttribute("restoran",newRestoranData);

        return "change-restoran";
    }
    @RequestMapping("/restoran/view")
    public String viewWithRequestParam(
            @RequestParam(value = "idRestoran") Long idRestoran, Model model){
        Optional<RestoranModel> restoran = restoranService.getRestoranByIdRestoran(idRestoran);
        if(restoran==null|| idRestoran.equals("")){
            return "error";
        }
        else{
            model.addAttribute("resto",restoran);

            return "view-restoran";
        }
    }

    @RequestMapping("/restoran/viewall")
    public String viewAll(Model model){
        List<RestoranModel> listRestoran = restoranService.getRestoranList();
        Collections.sort(listRestoran, new Comparator<RestoranModel>() {
            @Override
            public int compare(RestoranModel o1, RestoranModel o2) {
                return o1.getNama().compareTo(o2.getNama());
            }
        });
        model.addAttribute("restoList",listRestoran);

        return "viewall-restoran";
    }

//    @RequestMapping("/restoran/update/id-restoran/{idRestoran}/nomor-telepon/{nomorTelepon}")
//    public String viewWithUpdatedTelephoneNumber(
//            @PathVariable("idRestoran") String idRestoran,
//            @PathVariable("nomorTelepon") Integer nomorTelepon, Model model){
//            RestoranModel restoran = restoranService.updateNomorTelepon(idRestoran,nomorTelepon);
//            if(restoran==null||idRestoran.equals("")){
//                return "error";
//            }
//            else{
//                model.addAttribute("resto",restoran);
//
//                return "view-restoran";
//            }
//
//    }

    //    @RequestMapping("/restoran/view/id-restoran/{idRestoran}")
//    public String viewWithPathVariable(
//            @PathVariable("idRestoran") String idRestoran, Model model){
//        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran);
//        if(restoran==null||idRestoran.equals("")){
//            return "error";
//        }
//        else{
//            model.addAttribute("resto",restoran);
//
//            return "view-restoran";
//        }
//
//    }
    @RequestMapping(value = "/restoran/delete/{idRestoran}")
    public String deleteRestoran(
            @PathVariable("idRestoran") Long idRestoran,
            Model model){
        RestoranModel restoToBeDelete = restoranService.getRestoranByIdRestoran(idRestoran).get();
        if(restoToBeDelete.getIdRestoran()==null||idRestoran.equals("")){
            return "error";
        }else{
            if(restoToBeDelete.getListMenu().isEmpty()==true){
                model.addAttribute("namaResto",restoToBeDelete.getNama());
                restoranService.deleteRestoran(idRestoran);
                return "delete-restoran";
            }else{
                return "error-restoran";
            }
        }
    }

//    @RequestMapping("/restoran/delete/id/{idRestoran}")
//    public String delete(
//            @PathVariable("idRestoran") String idRestoran, Model model
//    ){
//        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran);
//
//        if(restoran==null||idRestoran.equals("")){
//            return "error";
//        }
//        else{
//            model.addAttribute("namaResto",restoran.getNama());
//            restoranService.deleteRestoran(idRestoran);
//            return "delete-restoran";
//        }
//    }
}
