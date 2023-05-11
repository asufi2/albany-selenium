package HomeWork;

        public class Week1Hw {
        //This is problem 1
        public int[] arrayFirstElement(int c[], int d[]) {
            int[] problem1 = {c[0], d[0]};
            return problem1;
        }

        //This is problem 2
        public int[] arrayMiddle(int e[]) {
            //int [] e = {1,2,3,4,5,6,7,8};
            int middleValue = e.length / 2;
            int[] actualMiddle = {e[middleValue - 1], e[middleValue]};
            return actualMiddle;
        }

        //This is problem 3
        public int arraySummation(int[] f) {
            int totalAdd = 0;
            for (int i = 0; i < f.length; i++) {
                totalAdd += f[i];
            }
            return totalAdd;
        }
    }

