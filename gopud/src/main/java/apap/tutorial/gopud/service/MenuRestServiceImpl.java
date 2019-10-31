package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.repository.MenuDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MenuRestServiceImpl implements MenuRestService{
    @Autowired
    private MenuDB menuDB;

    @Override
    public MenuModel createMenu(MenuModel menu) {
        return menuDB.save(menu);
    }

    @Override
    public List<MenuModel> retrieveListMenu() {

        return menuDB.findAll();
    }

    @Override
    public MenuModel getMenuByIdMenu(Long idMenu) {
        return menuDB.findById(idMenu).get();
    }

    @Override
    public MenuModel changeMenu(Long idMenu, MenuModel menuUpdate) {
        MenuModel targetMenu = menuDB.findById(idMenu).get();
        try{
            targetMenu.setNama(menuUpdate.getNama());
            targetMenu.setHarga(menuUpdate.getHarga());
            targetMenu.setDurasiMasak(menuUpdate.getDurasiMasak());
            targetMenu.setDeskripsi(menuUpdate.getDeskripsi());
            menuDB.save(targetMenu);
            return targetMenu;
        } catch (NullPointerException nullException){
            return null;
        }
    }

    @Override
    public void deleteMenu(Long idMenu) {
        MenuModel targetMenu = menuDB.findById(idMenu).get();
        menuDB.delete(targetMenu);
    }
}
