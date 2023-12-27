package pixcompoo;

import java.util.Scanner;

public class Pix {
    public int numConta;
    protected String tipo;
    private String dono;
    private double saldo;
    private boolean status;

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }
    public int getNumConta() {
        return numConta;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getTipo() {
        return tipo;
    }
    public void setDono(String dono) {
        this.dono = dono;
    }
    public String getDono() {
        return dono;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public boolean getStatus(){
        return status;
    }
    public void status(){
        System.out.println("Número da conta: " + this.numConta);
        System.out.println("Tipo: " + this.tipo);
        System.out.println("Dono: "+ this.dono);
        System.out.println("Saldo: " +this.saldo + " R$" );
        System.out.println("Status: " + this.status);
    }
    public void abrirConta(){
        setNumConta(123456789);
        setSaldo(0);
        setStatus(true);
    }
    public void fecharConta(){
        if (saldo != 0) {
            System.out.println("Conta não pode ser fechada");
        }else{
            setStatus(false);
            System.out.println("Conta fechada: " + getStatus());
        }
    }
    public void sacar(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Valor do saque: ");
        double saque = scanner.nextDouble();
        if (saque > getSaldo()) {
            System.out.println("Erro dinheiro insuficiente!!");
        }else if(saque > 0 && saque <= getSaldo()){
            setSaldo(getSaldo() - saque);
            System.out.println("Saque feito no valor de: " + saque +"R$" + "Saldo restante:" + getSaldo());
        }
       
    }
     public void depositar() {
        Scanner deposito = new Scanner(System.in);
        System.out.print("Valor do depósito: ");
        double valorDeposito = deposito.nextDouble();
        setSaldo(getSaldo() + valorDeposito);
        
    }
    public void pagarMensal(){
        getTipo();
        if (getTipo().equals("CC")) {
            setSaldo(getSaldo() - 20);
        }else if(getTipo().equals("CP")){
            setSaldo(getSaldo() - 12);
        }else{
            System.out.println("Conta invalida");
        }
        
    } 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pix pix = new Pix();
        int resposta;
        int resp;
        do {
            System.out.println("Menu");
            System.out.println("[1] Cria conta");
            System.out.println("[2] Fechar contar");
            System.out.println("[3] Depositar");
            System.out.println("[4] Sacar");
            System.out.println("[5] Pagar taxa mensal");
            System.out.println("[6] Sair");
            resp = scanner.nextInt();
            switch (resp) {
                case 1:
                    do {
                System.out.println("Que tipo de conta você deseja abrir poupança ou corrente");
                System.out.println("[1] Poupança");
                System.out.println("[2] Corrente");
                System.out.println("[4] voltar");
                resposta = scanner.nextInt();
                    switch (resposta) {
                    case 1:
                    System.out.println("Conta poupança");
                    pix.setTipo("CP");
                    pix.setDono("Daniel");
                    pix.abrirConta();
                    pix.setSaldo(150);
                    pix.status();
                    break;
                    case 2:
                    System.out.println("Conta corrente");
                    pix.setTipo("CC");
                    pix.setDono("Daniel");
                    pix.abrirConta();
                    pix.setSaldo(50);
                    pix.status();
                    break;   
                }

            } while (resposta != 4);
                    break;
                case 2:
                    pix.fecharConta();
                    break;
                case 3:
                    pix.depositar();
                    pix.status();
                    break;
                case 4:
                    pix.sacar();
                    break;
                case 5:
                    pix.pagarMensal();
                    pix.status();
                    break;
                default:
                    break;
            }

        } while (resp != 6);   
    }   
}
