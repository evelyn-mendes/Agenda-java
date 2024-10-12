package com.evelyn.project.agenda;

import java.util.Scanner;

/**
 * <h1> Agenda </h1>
 * 
 * <p> O programa tem como premissa ser uma agenda pessoal. Onde você pode adicionar compromissos sinalizando o mês, dia e hora.</p>
 * 
 * <h4> Language: Java </h4>
 * 
 * @author Evelyn Mendes
 * @version 1.0
 * @since 11/10/2024
 */

public class MainAgenda {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        Agenda agenda = new Agenda();

        boolean opcaoValida = false; //Flag
        boolean diaValido;
        boolean horaValida;
        boolean mesValido;

        byte opcao;

        int dia = 0;
        int hora = 0;
        int mes = 0;
        String compromisso = "";

        while(!opcaoValida) {

            agenda.retornarTabelaOpc();

            System.out.print("\nEscolha uma opção: ");
            opcao = input.nextByte();

            System.out.println();

            switch(opcao) {
                
                case 1: //Adicionar compromisso

                    diaValido = false;
                    horaValida = false;
                    mesValido = false;

                    while(!mesValido) {

                        System.out.print("Digite o mês:  ");
                        mes = input.nextInt();
                        
                        if(mes > 0 && mes <= 12) {
                            mesValido = true;
                        } else {
                            System.out.println("\nErro: Digite um mês válido.");
                        }
                    }

                    while(!diaValido) {

                        System.out.print("Digite o dia: ");
                        dia = input.nextInt();

                        if(dia > 0 && dia <= 31) {
                            diaValido = true;
                        } else {
                            System.out.println("\nErro: Digite um dia válido.");
                        }
                    }

                    while(!horaValida) {

                        System.out.print("Digite a hora: ");
                        hora = input.nextInt();

                        if(hora > 0  && hora <= 8) {
                            horaValida = true;
                        } else {
                            System.out.println("\nErro: Digite uma hora válida.");
                        }
                    }

                    input.nextLine();

                    mes--;
                    dia--;
                    hora--;
                    System.out.print("Digite o comprimisso: ");
                    compromisso = input.nextLine();

                    agenda.adicionarCompromisso(mes, dia, hora, compromisso);

                    break;

                case 2: //Consultar Compromissos

                    diaValido = false;
                    horaValida = false;
                    mesValido = false;
                    int opcaoConsulta = 0;
                    boolean consultaValida = false;

                    System.out.println("============= Consulta =============");
                    System.out.println("1 - Consultar agenda de um Mês\n2 - Consultar agenda de um Dia\n3 - Consultar por data especifíca(mês, dia e hora)");
                    
                    while(!consultaValida) {

                        System.out.print("Digite a opção: ");
                        opcaoConsulta = input.nextInt();

                        if(opcaoConsulta == 1 || opcaoConsulta == 2 || opcaoConsulta == 3) {
                            consultaValida = true;
                        } else {
                            System.out.println("Erro: Opção inválida. Por favor, digite uma das opções acima.");
                        }
                    }

                    System.out.println();
                    if(opcaoConsulta == 3) {
   
                        while(!mesValido) {

                            System.out.print("Digite o mês:  ");
                            mes = input.nextInt();
                            
                            if(mes > 0 && mes <= 12) {
                                mesValido = true;
                            } else {
                                System.out.println("\n-> Erro: Digite um mês válido.");
                            }
                        }
    
                        while(!diaValido) {
    
                            System.out.print("Digite o dia: ");
                            dia = input.nextInt();
    
                            if(dia > 0 && dia <= 31) {
                                diaValido = true;
                            } else {
                                System.out.println("\n-> Erro: Digite um dia válido.");
                            }
                        }
    
                        while(!horaValida) {
    
                            System.out.print("Digite a hora: ");
                            hora = input.nextInt();
    
                            if(hora > 0 && hora <= 8) {
                                horaValida = true;
                            } else {
                                System.out.println("\n-> Erro: Digite uma hora válido.");
                            }
                        }

                        dia--;
                        mes--;
                        System.out.println(agenda.getCompromissos(mes, dia, hora));

                    } else if(opcaoConsulta == 1) {

                        while(!mesValido) {

                            System.out.print("Digite o mês:  ");
                            mes = input.nextInt();
                            
                            if(mes > 0 && mes <= 12) {
                                mesValido = true;
                            } else {
                                System.out.println("\n-> Erro: Digite um mês válido.");
                            }
                        }

                        mes--;
                        System.out.println(agenda.consultarCompromissosMes(mes));
                    
                    } else if(opcaoConsulta == 2) {

                        while(!diaValido) {

                            System.out.print("Digite o dia: ");
                            dia = input.nextInt();

                            if(dia > 0 && dia <= 31) {
                                diaValido = true;
                            } else {
                                System.out.println("\n-> Erro: Digite um mês válido.");
                            }
                        }

                        dia--;
                        System.out.println(agenda.consultarCompromissosDia(dia));
                    }

                    break;

                case 0:
                    System.out.println("Encerrando...");

                    opcaoValida = true;
                    break;

                default:
                    System.out.println("\nErro: Opção Inválida.");
            }
        }

        input.close();
    }
}
