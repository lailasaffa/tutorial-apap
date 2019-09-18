package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.RestoranModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

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
    public RestoranModel getRestoranByIdRestoran(String id) {
        for(RestoranModel restoran: listRestoran){
            if(restoran.getIdRestoran().equals(id)){
                return restoran;
            }
        }
        return null;
    }

    @Override
    public RestoranModel updateNomorTelepon(String id, Integer nomorTelepon) {
        for(RestoranModel restoran : listRestoran){
            if(restoran.getIdRestoran().equals(id)){
                restoran.setNomorTelepon(nomorTelepon);
                return restoran;
            }
        }
        return null;
    }

    @Override
    public void deleteRestoran(String id) {
        for(RestoranModel restoran : listRestoran){
            if(restoran.getIdRestoran().equals(id)){
                listRestoran.remove(restoran);
                break;
            }
        }
    }
}
