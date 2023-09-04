import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        long N=Long.parseLong(st.nextToken());
        long M=Long.parseLong(st.nextToken());

        long[] time=new long[(int)N];
        long max=0;
        long min=Long.MAX_VALUE;
        for(int i=0;i<N;i++){
            time[i]=Long.parseLong(br.readLine());
            max=Math.max(time[i],max);
            min=Math.min(min,time[i]);
        }

        long left=min;
        long right=max*M;
        while(left<=right){
            long mid=(left+right)/2;

            // 주어진 시간내에 처리할 수 있는 심사 인원
            long cnt=0;
            for(int i=0;i<N;i++){
                cnt+=mid/time[i];
            }

            if(cnt<M){
                left=mid+1;
            }else{right=mid-1;
            }
        }

        System.out.println(left);
    }
}