package apap.tutorial.gopud.controller;

import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.service.MenuService;
import apap.tutorial.gopud.service.RestoranService;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.util.ArrayList;


@Controller
public class MenuController {
    @Autowired
    MenuService menuService;

    @Qualifier("restoranServiceImpl")
    @Autowired
    RestoranService restoranService;

//    @RequestMapping(value = "/menu/add/{idRestoran}",method = RequestMethod.GET)
//    private String addMenuFormPage(@PathVariable(value = "idRestoran") Long idRestoran, Model model){
//        MenuModel menu = new MenuModel();
//        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran).get();
//        menu.setRestoran(restoran);
//        model.addAttribute("menu",menu);
//        model.addAttribute("resto",restoran);
//        model.addAttribute("title","Form Add Menu");
//
//        return "form-add-menu";
//
//    }
//    @RequestMapping(value = "/menu/add",method = RequestMethod.POST)
//    private String addMenuSubmit(@ModelAttribute MenuModel menu, Model model){
//
//        menuService.addMenu(menu);
//        model.addAttribute("nama",menu.getNama());
//        model.addAttribute("title","Add Menu");
//        return "add-menu";
//    }
@RequestMapping(value = "/menu/add/{idRestoran}", method = RequestMethod.POST, params= {"save"})
private String addMenuSubmit(@PathVariable(value = "idRestoran") Long idRestoran,
                             @ModelAttribute RestoranModel restoran, ModelMap model) {
    RestoranModel targetRestoran = restoranService.getRestoranByIdRestoran(idRestoran).get();
    model.addAttribute("idRestoran", idRestoran);
    for (MenuModel menu : restoran.getListMenu()) {
        menu.setRestoran(targetRestoran);
        menuService.addMenu(menu);
    }
    model.clear();
    return "add-menu";
}

    @RequestMapping(value = "menu/change/{id}",method = RequestMethod.GET)
    public String changeMenuFormPage(@PathVariable Long id, Model model){
        MenuModel existingMenu = menuService.getMenuByIdMenu(id).get();
        model.addAttribute("menu",existingMenu);
        model.addAttribute("title","Form Change Menu");
        return "form-change-menu";
    }

    @RequestMapping(value = "menu/change/{id}",method = RequestMethod.POST)
    public String changeMenuFormSubmit(
            @PathVariable Long id,
            @ModelAttribute MenuModel menu,
            Model model
    ){
        MenuModel newMenuData = menuService.changeMenu(menu);
        model.addAttribute("menu",newMenuData);
        model.addAttribute("title","Change Menu");

        return "change-menu";
    }

//    @RequestMapping("/menu/delete/{idMenu}")
//    public String deleteMenu(
//            @PathVariable Long idMenu, Model model
//    ){
//        MenuModel menu = menuService.getMenuByIdMenu(idMenu).get();
//        if(menu.getId()==null||idMenu.equals("")){
//            return "error-menu";
//        }else{
//            model.addAttribute("namaMenu",menu.getNama());
//            menuService.deleteMenu(idMenu);
//            return "delete-menu";
//        }
//
//    }
    @RequestMapping(value="menu/delete",method = RequestMethod.POST)
    private String delete(@ModelAttribute RestoranModel restoran, Model model){
        for(MenuModel menu: restoran.getListMenu()){
            MenuModel menuTarget = menuService.getMenuByIdMenu(menu.getId()).get();
            String namaMenu = menuTarget.getNama();
            model.addAttribute("namaMenu",namaMenu);
            model.addAttribute("title","Delete");
            Long idMenuTarget = menu.getId();
            menuService.deleteMenu(idMenuTarget);
        }
        return "delete-menu";
    }

    @RequestMapping(value = "/menu/add/{idRestoran}")
    private String add(@PathVariable(value = "idRestoran") Long idRestoran, Model model) {
        RestoranModel restoran = new RestoranModel();
        restoran.setListMenu(new ArrayList<MenuModel>());
        restoran.getListMenu().add(new MenuModel());
        model.addAttribute("restoran", restoran);
        model.addAttribute("idRestoran", idRestoran);
        model.addAttribute("title","Form Add Menu");
        return "form-add-menu";
    }

    @RequestMapping(value="/menu/add/{idRestoran}",method=RequestMethod.POST,params = {"addRow"})
    public String addRow(@PathVariable(value = "idRestoran") Long idRestoran,
                         @ModelAttribute RestoranModel restoran, Model model){
        MenuModel menu = new MenuModel();
        restoran.getListMenu().add(menu);
        model.addAttribute("restoran",restoran);
        model.addAttribute("idRestoran",idRestoran);
        model.addAttribute("title","Form Add Menu");
        return "form-add-menu";
    }

    @RequestMapping(value="/menu/add/{idRestoran}",method=RequestMethod.POST,params = {"removeRow"})
    public String removeRow(@PathVariable(value = "idRestoran") Long idRestoran,
                         @ModelAttribute RestoranModel restoran, Model model, HttpServletRequest req){
        Integer rowId = Integer.valueOf(req.getParameter("removeRow"));
        restoran.getListMenu().remove(rowId.intValue());
        model.addAttribute("restoran",restoran);
        model.addAttribute("idRestoran",idRestoran);
        model.addAttribute("title","Form Add Menu");
        return "form-add-menu";
    }


}
