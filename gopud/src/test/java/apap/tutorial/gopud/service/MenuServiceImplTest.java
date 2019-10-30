package apap.tutorial.gopud.service;
import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.repository.MenuDB;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.validation.constraints.Null;
import java.awt.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MenuServiceImplTest {
    @InjectMocks
    MenuService menuService = new MenuServiceImpl();

    @Mock
    MenuDB menuDB;

    @Test
    public void whenAddValidMenuItShouldCallMenuRepositorySave(){
        MenuModel newMenu = new MenuModel();
        newMenu.setNama("mcspicy");
        newMenu.setDeskripsi("myspicy deskripsi");
        newMenu.setHarga(BigInteger.valueOf(10000));
        newMenu.setDurasiMasak(15);

        menuService.addMenu(newMenu);

        verify(menuDB,times(1)).save(newMenu);
    }

    @Test
    public void whenChangeMenuCalledItShouldChangeMenuData(){
        MenuModel updatedMenu = new MenuModel();
        updatedMenu.setNama("gochujang");
        updatedMenu.setDeskripsi("ayam gochujang");
        updatedMenu.setHarga(BigInteger.valueOf(15000));
        updatedMenu.setDurasiMasak(100);
        updatedMenu.setId((long)1);

        when(menuDB.findById(1L)).thenReturn(Optional.of(updatedMenu));

        when(menuService.changeMenu(updatedMenu)).thenReturn(updatedMenu);

        MenuModel dataFromServiceCall = menuService.changeMenu(updatedMenu);

        assertEquals("gochujang",dataFromServiceCall.getNama());
        assertEquals("ayam gochujang", dataFromServiceCall.getDeskripsi());
        assertEquals(BigInteger.valueOf(15000), dataFromServiceCall.getHarga());
        assertEquals(Integer.valueOf(100),dataFromServiceCall.getDurasiMasak());
        assertEquals(Long.valueOf(1),dataFromServiceCall.getId());
    }

    @Test
    public void whenChangeMenuCalledItShouldReturnNullPointerException(){
        MenuModel updatedMenu = new MenuModel();
        updatedMenu.setNama("gochujang");
        updatedMenu.setDeskripsi("ayam gochujang");
        updatedMenu.setHarga(BigInteger.valueOf(15000));
        updatedMenu.setDurasiMasak(100);
        updatedMenu.setId((long)1);

        when(menuDB.findById(1L)).thenReturn(Optional.of(updatedMenu));
        when(menuService.changeMenu(updatedMenu)).thenThrow(NullPointerException.class);
        MenuModel dataFromServiceCall = menuService.changeMenu(updatedMenu);
        assertEquals(null,dataFromServiceCall);
    }

    @Test
    public void whenGetMenuByIdCalledByExistingDataItShouldReturnCorrectData(){
        MenuModel returnedMenu = new MenuModel();
        returnedMenu.setNama("steak ayam");
        returnedMenu.setDeskripsi("steak ayam deskripsi");
        returnedMenu.setHarga(BigInteger.valueOf(15000));
        returnedMenu.setDurasiMasak(Integer.valueOf(100));
        returnedMenu.setId(Long.valueOf(1));

        when(menuService.getMenuByIdMenu(1L)).thenReturn(Optional.of(returnedMenu));

        Optional<MenuModel> dataFromServiceCall = menuService.getMenuByIdMenu(1L);

        verify(menuDB,times(1)).findById(1L);
        assertTrue(dataFromServiceCall.isPresent());

        MenuModel dataFromOptional = dataFromServiceCall.get();
        assertEquals("steak ayam",dataFromOptional.getNama());
        assertEquals("steak ayam deskripsi",dataFromOptional.getDeskripsi());
        assertEquals(BigInteger.valueOf(15000),dataFromOptional.getHarga());
        assertEquals(Integer.valueOf(100),dataFromOptional.getDurasiMasak());
        assertEquals(Long.valueOf(1),dataFromOptional.getId());
    }
    @Test
    public void whenDeleteMenuCalledByExistingDataItShouldCallMenuRepositoryDelete(){
        MenuModel returnedMenu = new MenuModel();
        returnedMenu.setNama("steak ayam");
        returnedMenu.setDeskripsi("steak ayam deskripsi");
        returnedMenu.setHarga(BigInteger.valueOf(15000));
        returnedMenu.setDurasiMasak(Integer.valueOf(100));
        returnedMenu.setId(Long.valueOf(1));

        when(menuService.getMenuByIdMenu(1L)).thenReturn(Optional.of(returnedMenu));

        menuService.deleteMenu(1L);
        verify(menuDB,times(1)).delete(returnedMenu);
    }
    @Test
    public void whenFindAllMenuCalledByExistingRestoranDataItShouldReturnCorrectData(){
        List<MenuModel> allMenuInDatabase = new ArrayList<>();
        for (int loopTimes = 3; loopTimes > 0; loopTimes--) {
            allMenuInDatabase.add(new MenuModel());
        }
        when(menuService.findAllMenuByIdRestoran(Long.valueOf(1))).thenReturn(allMenuInDatabase);
        List<MenuModel> dataFromServiceCall = menuService.findAllMenuByIdRestoran(Long.valueOf(1));
        assertEquals(3, dataFromServiceCall.size());
        verify(menuDB, times(1)).findByRestoranIdRestoran(Long.valueOf(1));
    }
    @Test
    public void whenGetListMenuByExistingRestoranItShouldOrderByHargaAsc(){
        List<MenuModel> allMenuInDatabase = new ArrayList<>();
        for (int loopTimes = 3; loopTimes > 0; loopTimes--) {
            allMenuInDatabase.add(new MenuModel());
        }
        when(menuService.getListMenuOrderByHargaAsc(Long.valueOf(1))).thenReturn(allMenuInDatabase);
        List<MenuModel> dataFromServiceCall = menuService.getListMenuOrderByHargaAsc(Long.valueOf(1));
        assertEquals(3, dataFromServiceCall.size());
        verify(menuDB, times(1)).findByRestoranIdRestoranOrderByHarga(Long.valueOf(1));
    }
}
