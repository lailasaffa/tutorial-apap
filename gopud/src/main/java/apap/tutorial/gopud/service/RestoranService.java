package apap.tutorial.gopud.service;
import java.util.List;
import java.util.Optional;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.model.RestoranModel;

public interface RestoranService {
    void addRestoran( RestoranModel restoran);

    List<RestoranModel> getRestoranList();

    Optional<RestoranModel> getRestoranByIdRestoran(Long idRestoran);

    RestoranModel changeRestoran(RestoranModel restoranModel);


//    RestoranModel updateNomorTelepon(String idRestoran, Integer nomorTelepon);
//
    void deleteRestoran(Long idRestoran);
}


