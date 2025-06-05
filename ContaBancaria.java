import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Coleta de dados
        System.out.print("Digite o nome da pessoa: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o número da conta: ");
        String numeroConta = scanner.nextLine();

        System.out.print("Digite o saldo inicial: ");
        double saldoInicial = scanner.nextDouble();

        // Criação da conta
        ContaBancaria conta = new ContaBancaria(nome, numeroConta, saldoInicial);
        System.out.println("Conta bancária criada com sucesso.");

        // Menu de operações
        char opcao;
        do {
            System.out.println("\nEscolha uma operação:");
            System.out.println("D - Depositar");
            System.out.println("S - Sacar");
            System.out.println("C - Consultar saldo");
            System.out.println("Q - Sair");
            System.out.print("Opção: ");
            opcao = scanner.next().toUpperCase().charAt(0);

            switch (opcao) {
                case 'D':
                    System.out.print("Informe o valor para depósito: ");
                    double deposito = scanner.nextDouble();
                    conta.depositar(deposito);
                    break;

                case 'S':
                    System.out.print("Informe o valor para saque: ");
                    double saque = scanner.nextDouble();
                    conta.sacar(saque);
                    break;

                case 'C':
                    conta.consultarSaldo();
                    break;

                case 'Q':
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 'Q');

        scanner.close();
    }
}

////
public class ContaBancaria {
    private String nome;
    private String numeroConta;
    private double saldo;

    public ContaBancaria(String nome, String numeroConta, double saldoInicial) {
        this.nome = nome;
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.printf("Depósito de R$ %.2f realizado com sucesso.\n", valor);
    }

    public void sacar(double valor) {
        if (valor > 5000) {
            System.out.println("Valor do saque acima do permitido.");
        } else if (valor > saldo) {
            System.out.println("Saldo insuficiente para realizar a operação.");
        } else {
            saldo -= valor;
            System.out.printf("Saque de R$ %.2f realizado com sucesso.\n", valor);
        }
    }

    public void consultarSaldo() {
        System.out.printf("Saldo disponível: R$ %.2f\n", saldo);
    }
}
