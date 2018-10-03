package javaapplication1;

import java.util.Random;
import javax.swing.JOptionPane;

public class JavaApplication1 {

    private Prisioneiro prisioneiro1;
    private Prisioneiro prisioneiro2;

    public static void main(String[] args) {
        int escolha = 0;
        Random gerador = new Random(19700621);

        //Criando as instâncias das minhas possíveis escolhas
        Escolha escolha1 = new Escolha();
        Escolha escolha2 = new Escolha();
        Escolha escolha3 = new Escolha();
        Escolha escolha4 = new Escolha();

        escolha1.setNome("Entregar");
        escolha2.setNome("Mentir");

        escolha3.setNome("Entregar");
        escolha4.setNome("Mentir");

        //Criando as instâncias dos meus 2 prisioneiros
        Prisioneiro prisioneiro1 = new Prisioneiro();
        Prisioneiro prisioneiro2 = new Prisioneiro();

        String nomeP1 = JOptionPane.showInputDialog("Qual seu nome prisioneiro?");
        prisioneiro1.setNome(nomeP1);
        prisioneiro1.setEscolha(escolha1);

        prisioneiro2.setNome("Gabriel-PC");

        while (escolha != 5) {
            String aux = JOptionPane.showInputDialog("Escolha uma das opções " + prisioneiro1.getNome()
                    + "\n[1] Entregar/Confessar\n"
                    + "[2] Não fizemos nada, é verdade essa opção\n"
                    + "[3] Não informar\n"
                    + "[4] Escolha random\n"
                    + "[5] Sair do programa");
            escolha = Integer.parseInt(aux);

            switch (escolha) {
                case 1: //se o valor de escolha for 1, significa que o prisioneiro1 confesssou
                    prisioneiro1.setEscolha(escolha1); //escolha1 = entregar
                    break;
                case 2: //se o valor de escolha for 2, significa que o prisioneiro1 mentiu
                    prisioneiro1.setEscolha(escolha2); //escolha2 = mentiu
                    break;
                case 3: //se eu não informar qual escolha eu vou fazer, o prisioneiro2 terá que escolher entre as melhores opções disponíveis para ele
                    prisioneiro1.setEscolha(null);
                    break;
                case 4:
                    int random = gerador.nextInt(255); //escolha randômica entre entregar e confessar, 0 ou 1
                    if(random%2 == 1){
                        prisioneiro1.setEscolha(escolha1);
                    }else{
                        prisioneiro1.setEscolha(escolha2);
                    }
                    break;
                case 5: //apenas sai do programa
                    System.exit(0);
                    break;
            }
            if (prisioneiro1.getEscolha() == null) {
                //Estamos considerando o pior cenário para fazer a associação de valores
                escolha3.setGrau(5); //Se eu escolho confessar, posso pegar 5 ou 1 ano de prisão
                escolha4.setGrau(10); //Se eu escolho mentir, posso pegar 0 ou 10 anos de prisão
            } else if (prisioneiro1.getEscolha() == escolha1) { //se o prisioneiro1 escolheu confessar
                /* Vou atribuir um valor inteiro para cada possível resposta, 
                quanto mais próximo de 0 melhor para o prisioneiro,
                ou seja, ele passará menos tempo na prisão */
                escolha3.setGrau(1); //como ele escolheu confessar, a escolha1 (entregar) vale 1
                escolha4.setGrau(2); //como ele escolheu confessar, a escolha2 (mentir) vale 2 
                //ou seja, se ambos confessarem, o valor associado a esta escolha será de 1 (a melhor deste caso)
            } else if (prisioneiro1.getEscolha() == escolha2) {
                escolha3.setGrau(0); //como ele escolheu mentir, a escolha3 (entregar) vale 0
                escolha4.setGrau(2); //como ele escolheu mentir, a escolha4 (mentir) vale 2
                //ou seja, se ambos mentirem, o valor associado a esta escolha é a menor possível
            }
            //Agora devo decidir qual a melhor escolha para o Gabriel-PC, que será o menor valor associado as escolhas
            if (escolha3.getGrau() < escolha4.getGrau()) {
                prisioneiro2.setEscolha(escolha3);
            } else {
                prisioneiro2.setEscolha(escolha4);
            }
            JOptionPane.showMessageDialog(null, "O " + prisioneiro2.getNome() + " escolheu: " + prisioneiro2.getEscolha().getNome());

            if (prisioneiro1.getEscolha() != null) {
                //Resultado Final 
                if (prisioneiro1.getEscolha().getNome().equalsIgnoreCase("Mentir") && prisioneiro2.getEscolha().getNome().equalsIgnoreCase("Entregar")) {
                    JOptionPane.showMessageDialog(null, prisioneiro2.getNome() + " pegará 0 anos de prisão e " + prisioneiro1.getNome() + " pegará 10 anos");
                }
                if (prisioneiro1.getEscolha().getNome().equalsIgnoreCase("Entregar") && prisioneiro2.getEscolha().getNome().equalsIgnoreCase("Mentir")) {
                    JOptionPane.showMessageDialog(null, prisioneiro2.getNome() + " pegará 10 anos de prisão e " + prisioneiro1.getNome() + " pegará 0 anos");
                }
                if (prisioneiro1.getEscolha().getNome().equalsIgnoreCase("Entregar") && prisioneiro2.getEscolha().getNome().equalsIgnoreCase("Entregar")) {
                    JOptionPane.showMessageDialog(null, prisioneiro2.getNome() + " pegará 5 anos de prisão e " + prisioneiro1.getNome() + " pegará 5 anos");
                }
                if (prisioneiro1.getEscolha().getNome().equalsIgnoreCase("Mentir") && prisioneiro2.getEscolha().getNome().equalsIgnoreCase("Mentir")) {
                    JOptionPane.showMessageDialog(null, prisioneiro2.getNome() + " pegará 1 anos de prisão e " + prisioneiro1.getNome() + " pegará 1 anos");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Não sabemos sua escolha");
            }
        }
    }

}
