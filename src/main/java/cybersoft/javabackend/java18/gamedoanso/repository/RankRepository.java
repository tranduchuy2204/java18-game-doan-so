package cybersoft.javabackend.java18.gamedoanso.repository;

import cybersoft.javabackend.java18.gamedoanso.model.RankModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RankRepository extends AbstractRepository<RankModel> {
    public List<RankModel> getAllRankList() {
        return executeQuery(connection -> {
            String query = """
                    select p.username, game.id, count(game.id) played_times from player p
                    		left join game_session game
                    			on p.username = game.username
                    		left join guess
                    			on game.id = guess.session_id
                    	where game.is_completed = 1
                        group by game.id
                        order by played_times;
                    """;
            List<RankModel> listRank = new ArrayList<RankModel>();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                RankModel rankModel = new RankModel();
                rankModel.setUsername(resultSet.getString("username"));
                rankModel.setPlayedTimes(resultSet.getInt("played_times"));
                // lọc tên trùng
                if (listRank.stream().noneMatch(r -> r.getUsername().equals(rankModel.getUsername()))) {
                    listRank.add(rankModel);
                }
            }
            return listRank;
        });
    }
}
