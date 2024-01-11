import java.math.BigDecimal;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //input de dados.

        String name = "Roberto Tadeu";
        String accoutType = "Corrente";
        BigDecimal value = BigDecimal.valueOf(2500);
        String message = """
                **********************************
                Dados iniciais do cliente:
                                
                Nome: %s
                Tipo de conta: %s
                Saldo inicial: R$%.2f
                **********************************
                """.formatted(name, accoutType, value);
        String menu = """
                                
                                
                Operações
                                
                                
                1- Consultar saldos
                2- Receber valor
                3- Transferir valor
                4- Sair
                                
                Digite a opção desejada:
                """;

        System.out.println(message);

        int consult = 0;

        while (consult != 4) {
            //Loop do menu.

            System.out.println(menu);
            int options = input.nextInt();

            switch (options) {
                //Condiçoes do menu.
                case 1:
                    System.out.println("Seu saldo e de R$" + value + ".");
                    break;
                case 2:
                    System.out.println("Quanto você esta recebendo?");
                    BigDecimal received = input.nextBigDecimal();
                    if (received.intValue() < 0) {
                        System.out.println("Apenas numeros positivos pfv!");

                    } else {
                        value = receivedFunc(received, value);
                        System.out.println("Seu saldo e de R$" + value);

                    }
                    break;
                case 3:
                    System.out.println("Quanto você esta transferindo?");
                    BigDecimal transfer = input.nextBigDecimal();
                    if (testarBigDecimal(transfer, value)) {
                        value = transffunc(transfer, value);
                        System.out.println("Seu saldo e de R$" + value);
                    } else {
                        System.out.println("Saldo insuficiente!");

                    }
                    break;
                case 4:
                    System.out.println("Ate logo!");
                    consult = 4;
                    break;
                default:
                    System.out.println("Escolha uma opção entre 1 e 4!");
            }
        }


    }

    public static BigDecimal receivedFunc(BigDecimal received, BigDecimal value) {
        //Add um valor ao saldo.
        return received.add(value);
    }

    public static BigDecimal transffunc(BigDecimal transfer, BigDecimal value) {
        //Subtrai o valor a transferir do saldo.
        return value.subtract(transfer);
    }

    public static boolean testarBigDecimal(BigDecimal transfer, BigDecimal value) {
        //Compara o valor do saldo com o valor a transferir.
        return transfer.compareTo(value) < 0;
    }
}

