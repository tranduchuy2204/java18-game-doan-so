package cybersoft.javabackend.java18.gamedoanso.service;

import cybersoft.javabackend.java18.gamedoanso.model.RankModel;
import cybersoft.javabackend.java18.gamedoanso.repository.RankRepository;

import java.util.List;

public class RankService {
    private static RankService INSTANCE = null;
    public RankRepository rankRepository = new RankRepository();

    public static RankService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RankService();
        }
        return INSTANCE;
    }

    public List<RankModel> getAllRankList() {
        return this.rankRepository.getAllRankList();
    }
}
