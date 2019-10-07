package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.MenuModel;

import java.util.List;
import java.util.Optional;

public interface MenuService {
    void addMenu(MenuModel menu);
    void deleteMenu(Long idMenu);
    List<MenuModel> findAllMenuByIdRestoran(Long idRestoran);

    MenuModel changeMenu(MenuModel menuModel);

    Optional<MenuModel> getMenuByIdMenu(Long id);

    List<MenuModel> getListMenuOrderByHargaAsc(Long idRestoran);
}
