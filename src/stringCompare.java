public class stringCompare {

    /**
     * ��̬�滮�Ľ�������ʡ�ռ�
     * �ڶ�̬�滮�������ɷ�ʽ���У�ÿ����һ�У�ǰ�����һ�о��Ѿ�û�����ˣ�
     * �������ֻ��ʹ��һά���飬�����ǳ��õĶ�λ����
     */

    public static void getLCString(char[] str1, char[] str2) {  
        int len1, len2;  
        len1 = str1.length;  
        len2 = str2.length;  
        int maxLen = len1 > len2 ? len1 : len2;

        // ������Ӵ����ȵ�����
        int[] max = new int[maxLen];
        // ������Ӵ������������������
        int[] maxIndex = new int[maxLen];
        int[] c = new int[maxLen];  
  
        int i, j;  
        for (i = 0; i < len2; i++) {  
            for (j = len1 - 1; j >= 0; j--) {
                if (str2[i] == str1[j]) {  
                    if ((i == 0) || (j == 0)){
                        c[j] = 1;
                    }
                    else{
                        //��ʱC[j-1]�����ϴ�ѭ���е�ֵ����Ϊ��û�����¸�ֵ
                        c[j] = c[j - 1] + 1;
                    }
                } else {  
                    c[j] = 0;  
                }  
  
                // ����Ǵ�������ʱֻ��һ�������,����Ҫ�Ѻ������0;  
                if (c[j] > max[0]) {  
                    max[0] = c[j];  
                    maxIndex[0] = j;  
  
                    for (int k = 1; k < maxLen; k++) {  
                        max[k] = 0;  
                        maxIndex[k] = 0;  
                    }  
                }  
                // �ж������ͬ���ȵ��Ӵ�  
                else if (c[j] == max[0]) {  
                    for (int k = 1; k < maxLen; k++) {  
                        if (max[k] == 0) {  
                            max[k] = c[j];  
                            maxIndex[k] = j;  
                            break; // �ں����һ����Ҫ�˳�ѭ����  
                        }  
                    }  
                }  
            }  
//            for (int temp : c) {  
//                System.out.print(temp);  
//            }  
        }  
        //��ӡ����ַ���  
        for (j = 0; j < maxLen; j++) {  
            if (max[j] > 0) {  
                System.out.println("��" + (j + 1) + "�������Ӵ�:");  
                for (i = maxIndex[j] - max[j] + 1; i <= maxIndex[j]; i++){
                    System.out.print(str1[i]);
                }
                System.out.println(" ");  
            }  
        }  
    }  
  
    public static void main(String[] args) {  
  
        String str1 = new String("abcda");  
        String str2 = new String("adcba");  
        getLCString(str1.toCharArray(), str2.toCharArray());  
    }  
} 