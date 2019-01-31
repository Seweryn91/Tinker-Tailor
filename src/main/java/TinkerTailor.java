import java.util.LinkedList;
import java.util.List;

public class TinkerTailor {

    private int N; //number of players in circle
    private int K; //length of sequence

    class Player {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


    private List<Player> players = new LinkedList<>();

    public TinkerTailor(int N, int K) throws IllegalArgumentException {
        if (N < 2)
            throw new IllegalArgumentException("Number of players cannot be less than 2");
        if (K < 1)
            throw new IllegalArgumentException("Sequence cannot be shorter than 1");

        this.N = N;
        this.K = K;
        addPlayers(N);
        tinker(N, K);
    }

    private void addPlayers(int N) {

        for (int i = 0; i < N; i++) {
            Player player = new Player();
            player.setName(i + 1 + "");
            players.add(player);
            //System.out.println("Player " + player.getName() + " added.");
        }
    }

    private void tinker(int N, int K) {
        int indexToRemove = 0;

        while (N > 1) {
            indexToRemove = (indexToRemove + K - 1) % N;
            System.out.println("Player " + players.get(indexToRemove).getName() + " removed.");
            players.remove(indexToRemove);
            N--;
        }
        if (N == 1) {
            System.out.println("Player " + players.get(0).getName() + " wins!");
        }
    }

}
