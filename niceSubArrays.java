public class niceSubArrays {
        public int atMostGoal(int[] nums, int goal)
        {
            int i = 0, j = 0, ans = 0, sum = 0;
            int n = nums.length;
            while(j < n)
            {
                sum += nums[j];
                while(sum > goal &&  i <= j)
                {
                    sum -= nums[i];
                    i++;
                }
                ans += j - i + 1;
                j++;
            }
            return ans;
        }
        public int numberOfSubarrays(int[] nums, int k) {
            int n = nums.length;
            int[] dummy = new int[n];
            for(int i = 0; i < n; i++)
            {
                if(nums[i] % 2 == 0)
                {
                    dummy[i] = 0;
                }   
                else
                {
                    dummy[i] = 1;
                }
            }
            for(int al : dummy)
            {
                System.out.print(al + " ");
            }
            return atMostGoal(dummy, k) - atMostGoal(dummy, k-1);
            
        }
}
