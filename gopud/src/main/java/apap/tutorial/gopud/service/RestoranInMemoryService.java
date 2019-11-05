package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.model.RestoranModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class RestoranInMemoryService implements RestoranService{
    private List<RestoranModel> listRestoran;

    public RestoranInMemoryService(){
        listRestoran = new ArrayList<>();
    }
    @Override
    public void addRestoran(RestoranModel restoran){
        listRestoran.add(restoran);
    }

    @Override
    public List<RestoranModel> getRestoranList(){
        return listRestoran;
    }

    @Override
    public RestoranModel changeRestoran(RestoranModel restoranModel) {
        return null;
    }

    @Override
    public void deleteRestoran(Long idRestoran) {
        for(RestoranModel restoran : listRestoran){
            if(restoran.getIdRestoran().equals(idRestoran)){
                listRestoran.remove(restoran);
                break;
            }   
        }
    }

    @Override
    public Optional<RestoranModel> getRestoranByIdRestoran(Long idRestoran) {
        for(RestoranModel restoran: listRestoran){
            if(restoran.getIdRestoran().equals(idRestoran)){
                return Optional.ofNullable(restoran);
            }
        }
        return null;
    }
    public RestoranModel updateNomorTelepon(String id, Integer nomorTelepon) {
        for(RestoranModel restoran : listRestoran){
            if(restoran.getIdRestoran().equals(id)){
                restoran.setNomorTelepon(nomorTelepon);
                return restoran;
            }
        }
        return null;
    }
}
