package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.MenuModel;

import java.awt.*;
import java.util.List;
import java.util.Optional;

public interface MenuRestService {

//    Mono<String> getStatus(Long idRestoran);
//
//    Mono<RestoranDetail> postStatus();
    MenuModel createMenu(MenuModel menu);

    List<MenuModel> retrieveListMenu();

    MenuModel getMenuByIdMenu(Long idMenu);

    MenuModel changeMenu(Long idMenu, MenuModel menuUpdate);

    void deleteMenu(Long idMenu);


}
