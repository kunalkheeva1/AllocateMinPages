public class AllocateMinPages {

    static boolean check(int[] arr,int n, int m, int mid){
        // assume n initially we have atleast one student and 0 pages to read
        int count = 1;
        int pages = 0;


        for(int i= 0; i<n; i++){
            // pages increase wrt mid
            if(arr[i] + pages <= mid){
                pages += arr[i];
                // else student increases and reads another book
            }else{
                count ++;
                pages = arr[i];
            }
        }
        // and return true and false accordingly
        if(count<=m){
            return true;
        }else{
            return false;
        }
    }



    public static int allocateMinPages(int [] arr, int n, int m){


        int low = 0;
        int high = 0;

        //low is if there are n students and read n books, and the max page count is stored in low
        // High stores if one student reads all the books
        for(int i=0; i<n; i++){
            low = Math.max(low, arr[i]);
            high += arr[i];
        }
        int ans = -1;
        // our ans is contained in low to high
        while(low<=high){
            int mid = (low+ high)/2;
            // so if mid is the ans then check for another mid on LHS
            if((check(arr, n, m, mid))){
                high = mid-1;
                ans = mid;
                // else check the other half of the low - high
            }else{
                low = mid+1;
            }
        }return ans;


    }






    public static void main(String[] args) {

    }
}
