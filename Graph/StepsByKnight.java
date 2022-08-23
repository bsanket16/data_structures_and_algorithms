package Graph;

import java.util.ArrayDeque;
import java.util.Queue;

class Pairs
{
    int x, y;

    Pairs(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}


class StepsByKnight
{

    private boolean isValid(int x, int y, int N)
    {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int[] KnightPos, int[] TargetPos, int N)
    {
        int steps = 0;
        Queue<Pairs> queue = new ArrayDeque<>();

        queue.add(new Pairs(KnightPos[0]-1, KnightPos[1]-1));

        int[] dx = {2, 2, 1, -1, -2, -2, -1, 1};
        int[] dy = {1, -1, -2, -2, 1, -1, 2, 2};


        boolean[][] visited = new boolean[N][N];

        while(!queue.isEmpty())
        {
            int n = queue.size();
            steps++;

            for(int j=0; j<n; j++)
            {
                Pairs p = queue.poll();

                visited[p.x][p.y] = true;

                for(int i=0; i<8; i++)
                {
                    int x = p.x + dx[i];
                    int y = p.y + dy[i];

                    if(x == TargetPos[0]-1 && y == TargetPos[1]-1) return steps;


                    if(isValid(x, y, N) && !visited[x][y])
                    {
                        visited[x][y] = true;
                        queue.offer(new Pairs(x, y));
                    }
                }

            }
        }


        return -1;

    }
}
