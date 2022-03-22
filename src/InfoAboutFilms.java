import java.util.Scanner;
class Film{
    String name;
    double god;
    String country;
    String janr;
    double prokat;
}
public class InfoAboutFilms{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("count");
        int count = sc.nextInt();
        sc.nextLine();
        Film filmes[] = new Film[count];
        for (int i = 0; i < count; i++) {

            filmes[i] = new Film();
            System.out.println("Input name " + (i + 1));
            filmes[i].name = sc.nextLine();
            System.out.println("Input god " + (i + 1));
            filmes[i].god = sc.nextDouble();
            sc.nextLine();
            System.out.println("Input country " + (i + 1));
            filmes[i].country = sc.nextLine();
            System.out.println("Input janr " + (i + 1));
            filmes[i].janr = sc.nextLine();
            System.out.println("Input prokat" + (i + 1));
            filmes[i].prokat = sc.nextDouble();
            sc.nextLine();
        }
        System.out.println("Name \t god \t country \t janr \t prokat");
        for (int i = 0; i < count; i++) {
            System.out.println(filmes[i].name + "\t" + filmes[i].god + "\t" + filmes[i].country + "\t"
                    + filmes[i].janr + "\t" + filmes[i].prokat);
        }
        /* Определить ранний фильм */
        int mingod = 0;
        double godMin = filmes[mingod].god;
        for (int i = 1; i < count; i++) {
            if (filmes[i].god < godMin) {
                mingod = i;
                godMin = filmes[mingod].god;
            }
        }
        System.out.println("Film " + filmes[mingod].name + " with min god " + filmes[mingod].god);

        /* сортировка фильмов по алфавиту */
        for (int i = 0; i > filmes.length - 1; i++) {
            for (int j = 0; j < filmes.length - j - 1; j++) {
                if (filmes[j].name.compareTo(filmes[j + 1].name)> 0) {
                    Film temp = filmes[i];
                    filmes[i] = filmes[i + 1];
                    filmes[i + 1] = temp;
                }
            }
        }
        System.out.println("Sort by name to alphabet");
        for (int i = 0; i < filmes.length; i++) {
            System.out.println(filmes[i].name + "\t" + filmes[i].god + "\t" + filmes[i].country +
                    "\t" + filmes[i].janr + "\t" + filmes[i].prokat);
        }
        /*подсчитать среднюю стоимость проката введенных фильмов и определить стоимость проката больше средней */
        double prokatFilm = 0;
        for (int i = 0; i < filmes.length; i++){
            prokatFilm = prokatFilm + filmes[i].prokat;
        }
        double avgProkat = prokatFilm/count;
        System.out.println("avgProkat = " + avgProkat);
        System.out.println("Filmes with prokat > avgProkat");
        for (int i = 0; i < filmes.length; i++){
            if(filmes[i].prokat > avgProkat){
                System.out.println(filmes[i].name + "\t" + filmes[i].god + "\t" + filmes[i].country +
                        "\t" + filmes[i].janr + "\t" + filmes[i].prokat);
            }
        }
        //найти фильм по названию введенному пользователем
        System.out.println("Input film name");
        String searchName = sc.nextLine();
        int indexSearch = -1;
        for (int i = 0; i < filmes.length; i++){
            if (filmes[i].name.equalsIgnoreCase(searchName)){
                indexSearch = i ;
            }
        }
        if (indexSearch != -1){
            System.out.println("Film found");
            System.out.println(filmes[indexSearch].name + "\t" + filmes[indexSearch].god + "\t" + filmes[indexSearch].country +
                    "\t" + filmes[indexSearch].janr + "\t" + filmes[indexSearch].prokat);
            System.out.println("Введите номер поля для редактирования");
            System.out.println("1-name, 2-god, 3-country, 4-janr, 5-prokat");
            int indexR = sc.nextInt();
            sc.nextLine();
            switch (indexR){
                case 1:{
                    System.out.println("Введите новое имя");
                    String newName = sc.nextLine();
                    filmes[indexSearch].name = newName;
                    break;
                }
                case 2:{
                    System.out.println("Введите новое значение года ");
                    double newGod = sc.nextDouble();
                    filmes[indexSearch].god = newGod;
                    break;
                }
                case 3:{
                    System.out.println("Введите новую страну");
                    String newCountry = sc.nextLine();
                    filmes[indexSearch].country = newCountry;
                    break;
                }
                case 4:{
                    System.out.println("Введите новый жанр");
                    String newJanr = sc.nextLine();
                    filmes[indexSearch].janr = newJanr;
                    break;
                }
                case 5:{
                    System.out.println("Введите новый прокат ");
                    double newProkat = sc.nextDouble();
                    filmes[indexSearch].prokat = newProkat;
                    break;
                }
                default:{
                    System.out.println("Не найдено ");
                    break;
                }
            }
            System.out.println("Отредактированная информация");
            System.out.println(filmes[indexSearch].name + "\t" + filmes[indexSearch].god + "\t" + filmes[indexSearch].country +
                    "\t" + filmes[indexSearch].janr + "\t" + filmes[indexSearch].prokat);
        }
        else{
            System.out.println("Not found");
        }
    }
}