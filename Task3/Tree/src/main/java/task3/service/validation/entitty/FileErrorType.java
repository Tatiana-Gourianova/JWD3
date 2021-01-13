package task3.service.validation.entitty;

import task3.service.validation.entitty.XMLErrors;

import java.util.Scanner;

/* есть ли шаблоны классификации такого плана без заворотистых ифов?????????????
*пример такого плана: (нужен для того, чтобы сделать эффективнее исправление файла - если быстро определяешь тип, то паттерн исправления)
* попытка определить и оптимально классифицировать тип файла (по столбцам тип ошибки по строкам разновидность xml файла с ошибками)
*       +   +   +   -
*       +   +   -   -
*       -   +   +   -
*       +   -   -   +
*       +   -   -   +
*       +   -   -   -
 *     +   +   +   +
*/

public class FileErrorType extends XMLErrors {
    private final int CategoriesAmount;
    private boolean[][] massivTestTypes; //TestTableError;

    public FileErrorType(int n) {
       // super();
        boolean[][] massivTestTypes = new boolean[getCategory().length][n];
        CategoriesAmount = n;
    }

    public int getInstance() {
        return this.CategoriesAmount;
    }

    public void setMassivTestTypes() {
        this.massivTestTypes = TestMistakes(CategoriesAmount).clone();

    }

    public boolean[][] getMassivTestTypes() {
        return massivTestTypes;
    }

    @Override
    public void print(int answer) {

        for (int i = 0; i < XMLErrors.errXML.values().length; i++) {
            for (int j = 0; j < getInstance(); j++) {

                //boolean massivTestTypes;
                if (this.massivTestTypes[i][j] == true)
                    System.out.print(" Mistake in XML-file " + errXML.values()[answer].getCode());

            }
            System.out.print('\n');
        }
    }

    public boolean[][] TestMistakes(int categoriesAmountn) {
        boolean a[][] = new boolean[getCategory().length][categoriesAmountn];
        int count = 0;
        int count2 = 0;
        int answer3 = 0;
        String answ3 = "false";

        Scanner clavier = new Scanner(System.in);

        System.out.println("Has html-fale mistakes looks like a line break (true : yes, false : no)?");

        answ3 = clavier.nextLine();
        count++;

        if (answ3.contains("true")) {
            a[0][1] = true;
            a[1][1] = true;
            a[5][1] = true;

            System.out.println("Has html-fale mistakes looks like missing closing tag (true : yes, false : no) ? ");
            answ3 = clavier.nextLine();
            count++;
            if (answ3.contains("true")) {
                a[1][0] = true;
                a[5][0] = true;
            } else {
                answer3 = 0;
                count2++;
            }
        } else {
            System.out.println("Has html-fale mistakes looks like missing closing tag (true : yes, false : no) ? ");
            answ3 = clavier.nextLine();
            count++;
            if (answ3.contains("true")) {
                a[2][0] = true;
                a[4][0] = true;

            } else {
                answer3 = 3;
                count2++;
            }
        }


        if (count == 2) {
            System.out.println("Has html-fale mistakes looks like missing opening tag (true : yes, false : no) ? ");
            answ3 = clavier.nextLine();
            count++;

            if (answ3.contains("true")) {
                answer3 = 1;
                count2++;
                a[0][1] = true;
                a[1][1] = true;//?
                //             a[5][1] = true;// count++;
            } else {
                answer3 = 5;
                count2++;
            }
        }
        if ((count < 3) && (count2 == 0)) {
            System.out.println("Has html-fale mistakes looks like overlapping tags (true : yes, false : no) ?");
            answ3 = clavier.nextLine();
            count++;
            if (answ3.contains("true")) {
                answer3 = 2;
                count2++;
                a[2][3] = true;
                //a[1][3] = true;
            } else {
                System.out.println("Has html-fale mistakes looks like missing opening tag (true : yes, false : no) ?  ");
                answ3 = clavier.nextLine();
                count++;
                if (answ3.contains("true")) {
                    answer3 = 5;
                    count2++;
                } else {
                    if (count2 == 0) {
                        answer3 = 4;
                        count2++;
                    }

                }
            }


            if ((count2 == 0) && (a[0][0] == false) && (a[0][1] == true) && (a[0][2] = true)) {
                answer3 = 0;
            }
            if ((count2 == 0) && (a[1][0] == true) && (a[1][1] == true) && (a[1][2] = true)) {
                answer3 = 1;
            }

            if ((count2 == 0) && (a[2][0] == true) && (a[2][1] == false) && (a[2][2] == false)) {
                answer3 = 2;
            }


            if ((count2 == 0) && (a[4][0] == true) && (a[4][1] == false) && (a[4][2] == false)) {
                answer3 = 4;
            }
            if ((count2 == 0) && (a[3][0] == false) && (a[3][1] == false) && (a[3][2] == false)) {
                answer3 = 3;
            }
            if ((count2 == 0) && (a[5][0] == true) && (a[5][1] == true) && (a[5][2] == false)) {
                answer3 = 5;
            }

            XMLErrors errors = new XMLErrors();

            errors.print(answer3);

            clavier.close();

        }
//this.massivTestTypes=a.clone();
  return a;
         }
}