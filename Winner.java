import java.util.*;
class Winner {
    public int findTheWinner(int n, int k) {
      Queue<Integer> que = new LinkedList<>();
      for(int i = 1; i <= n; i++)
      {
        que.add(i);
      }
      while(que.size() > 1)
      {
        for(int j = 1; j < k; j++)
        {
            que.add(que.peek());
            que.remove();
        }
        que.remove();
      }

      return que.remove();
        
    }
}