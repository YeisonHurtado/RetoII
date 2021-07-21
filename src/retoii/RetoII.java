/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retoii;

import java.util.ArrayList;
import java.util.Scanner;
import person_pkg.AdminEmployeeClass;
import person_pkg.ClientPersonClass;
import person_pkg.EmployeePersonClass;
import person_pkg.PositionEmployeeClass;
import styles.StylesInterface;

/**
 *
 * @author ydhurtado
 */
public class RetoII {

    static Scanner inst_input_data = new Scanner(System.in);
    static ArrayList listEmployeesPerson = new ArrayList();
    static ArrayList listClientsPerson = new ArrayList();
    static ArrayList listPositionEmployee = new ArrayList();
    static ArrayList listSubordinates = new ArrayList();
    static ArrayList newListEmployees = new ArrayList();
    static ArrayList listAdmin = new ArrayList();

    /* FUNCIONES POSICION */
    public static void createPosition() {
        System.out.println("Crear cargos. ¿Cuántos deseas crear? ...");
        int quantity = Integer.parseInt(inst_input_data.nextLine());

        for (int i = 0; i < quantity; i++) {
            PositionEmployeeClass inst_position = new PositionEmployeeClass();
            System.out.println("\n" + StylesInterface.ANSI_RED + "Cargo " + (i + 1) + StylesInterface.ANSI_RESET);

            System.out.println(StylesInterface.ANSI_RED + "Nivel jerarquico: " + StylesInterface.ANSI_RESET);
            String hierarchy = inst_input_data.nextLine();

            System.out.println(StylesInterface.ANSI_RED + "Nombre del cargo: " + StylesInterface.ANSI_RESET);
            String name_position = inst_input_data.nextLine();

            inst_position.createPosition(hierarchy, name_position);
            listPositionEmployee.add(inst_position);
        }
    }

    public static void listPosition() {
        for (int i = 0; i < listPositionEmployee.size(); i++) {
            PositionEmployeeClass position = (PositionEmployeeClass) listPositionEmployee.get(i);
            System.out.println(position.readPositions(i + 1));
        }
    }

    /* FUNCIONES ADMIN */
    public static void createAdmin() {
        System.out.println("Elige un empleado para un cargo administrativo (1 - " + listEmployeesPerson.size() + ":");
        listEmployees(listEmployeesPerson.size());
        int index_employee = Integer.parseInt(inst_input_data.nextLine()) - 1;

        EmployeePersonClass employee = (EmployeePersonClass) listEmployeesPerson.get(index_employee);
        AdminEmployeeClass inst_admin = new AdminEmployeeClass(employee.getName(), employee.getLast_name(), employee.getId(), employee.getEmail());

        System.out.println("Asignar cantidad de subordinados (" + (listEmployeesPerson.size() - 1) + "): ");
        int quantity_sub = 0;

        while (true) {
            quantity_sub = Integer.parseInt(inst_input_data.nextLine());
            if (quantity_sub > 0 && quantity_sub <= (listEmployeesPerson.size() - 1)) {
                System.out.println(StylesInterface.ANSI_BLUE + "\n---- Empleados ----" + StylesInterface.ANSI_RESET);
                for (int i = 0; i < listEmployeesPerson.size(); i++) {
                    EmployeePersonClass inst_employee = (EmployeePersonClass) listEmployeesPerson.get(i);
                    if (inst_employee.getId() != inst_admin.getId()) {
                        newListEmployees.add(inst_employee);
                        System.out.println("\n" + (i + 1) + ". " + inst_employee.getId() + "\t" + inst_employee.getName() + " " + inst_employee.getLast_name());
                    }
                }

                System.out.println(StylesInterface.ANSI_PURPLE + "Selecciona los empleados por su indice (1 - " + newListEmployees.size() + ")" + StylesInterface.ANSI_RESET);
                for (int i = 0; i < quantity_sub; i++) {
                    System.out.println("\nSubordinado " + (i + 1) + ": ");
                    int index_sub = Integer.parseInt(inst_input_data.nextLine()) - 1;
                    EmployeePersonClass sub_employees = (EmployeePersonClass) newListEmployees.get(index_sub);
                    listSubordinates.add(sub_employees);
                }
                inst_admin.setSubordinates(listSubordinates);
                inst_admin.setNum_subordinates(listSubordinates.size());
                listAdmin.add(inst_admin);
                System.out.println(StylesInterface.ANSI_GREEN + "Información" + StylesInterface.ANSI_RESET);
                listAdmin();
                break;
            } else {
                System.out.println(StylesInterface.ANSI_RED + "Cantidad fuera de rango!" + StylesInterface.ANSI_RESET);
            }
        }

    }
    
    public static void listAdmin(){
        AdminEmployeeClass admin = (AdminEmployeeClass) listAdmin.get(0);
        EmployeePersonClass subordinates;
        
        String full_name_admin = admin.getName() + " " + admin.getLast_name();
        System.out.println(StylesInterface.ANSI_RED + "Administrador: " + StylesInterface.ANSI_RESET + admin.getId() + "\t" + full_name_admin);
        System.out.println(StylesInterface.ANSI_PURPLE + "Subordinados: " + StylesInterface.ANSI_RESET);
        for (int i = 0; i < admin.getSubordinates().size(); i++) {
            subordinates = (EmployeePersonClass) admin.getSubordinates().get(i);
            String full_name = subordinates.getName() + " " + subordinates.getLast_name();
            System.out.println((i + 1) + ". " + subordinates.getId() + "\t" + full_name);
        }
    }

    /* FUNCIONES DE EMPLEADO */
    public static void createEmployees(int cant) {
        for (int i = 0; i < cant; i++) {
            System.out.println(StylesInterface.ANSI_RED + "\n****** EMPLEADO " + (i + 1) + "******" + StylesInterface.ANSI_RESET);

            System.out.println(StylesInterface.ANSI_BLUE + "Número de documento:" + StylesInterface.ANSI_RESET);
            int id_employee = Integer.parseInt(inst_input_data.nextLine());

            System.out.println(StylesInterface.ANSI_BLUE + "Nombre empleado:" + StylesInterface.ANSI_RESET);
            String name_employee = inst_input_data.nextLine();

            System.out.println(StylesInterface.ANSI_BLUE + "Apellido empleado:" + StylesInterface.ANSI_RESET);
            String last_name_employee = inst_input_data.nextLine();

            System.out.println(StylesInterface.ANSI_BLUE + "Salario:" + StylesInterface.ANSI_RESET);
            int salary = Integer.parseInt(inst_input_data.nextLine());

            System.out.println(StylesInterface.ANSI_BLUE + "Correo electronico:" + StylesInterface.ANSI_RESET);
            String email_employee = inst_input_data.nextLine();

            EmployeePersonClass inst_employee = new EmployeePersonClass(name_employee, last_name_employee, id_employee, email_employee);

            System.out.println(StylesInterface.ANSI_YELLOW + "Añade un cargo (1 - " + listPositionEmployee.size() + ") " + StylesInterface.ANSI_RESET);
            listPosition();
            int index_position = Integer.parseInt(inst_input_data.nextLine()) - 1;
            PositionEmployeeClass position = (PositionEmployeeClass) listPositionEmployee.get(index_position);

            inst_employee.setSalary(salary);
            inst_employee.setPosition(position);
            listEmployeesPerson.add(inst_employee);

        }
    }

    public static void listEmployees(int cant) {
        for (int i = 0; i < cant; i++) {
            EmployeePersonClass employe = (EmployeePersonClass) listEmployeesPerson.get(i);
            System.out.println(employe.getEmployee(employe.getId()));
        }
    }

    public static void removeEmployee(int id_employee) {
        for (int i = 0; i < listEmployeesPerson.size(); i++) {
            EmployeePersonClass employee = (EmployeePersonClass) listEmployeesPerson.get(i);
            if (employee.getId() == id_employee) {
                System.out.println(StylesInterface.ANSI_RED + "\nEmpleado eliminado" + StylesInterface.ANSI_RESET);
                System.out.println(StylesInterface.ANSI_RED + "Nro. documento: " + StylesInterface.ANSI_RESET + employee.getId());
                System.out.println(StylesInterface.ANSI_RED + "Nombre: " + StylesInterface.ANSI_RESET + employee.getName() + " " + employee.getLast_name());

                listEmployeesPerson.remove(employee);
            }
        }
    }

    public static void editEmployee(int index) {
        if (index >= 0 && index <= listEmployeesPerson.size()) {
            EmployeePersonClass inst_employee = (EmployeePersonClass) listEmployeesPerson.get(index);

            inst_employee.getEmployee(inst_employee.getId());

            System.out.println("¿Deseas editar?\n\t1.Nombre.\n\t2. Documento.\n\t3. Email.\n\t4. Salario.");
            int option_edit = Integer.parseInt(inst_input_data.nextLine());

            System.out.println(StylesInterface.ANSI_BLUE + "Ingresa el nuevo valor: " + StylesInterface.ANSI_RESET);
            switch (option_edit) {
                case 1:
                    String new_name = inst_input_data.nextLine();
                    inst_employee.setName(new_name);
                    break;
                case 2:
                    int new_id = Integer.parseInt(inst_input_data.nextLine());
                    break;
                case 3:
                    String new_email = inst_input_data.nextLine();
                    inst_employee.setEmail(new_email);
                    break;
                case 4:
                    int new_salary = Integer.parseInt(inst_input_data.nextLine());
                    inst_employee.setSalary(new_salary);
                    break;
                default:
                    break;
            }

            removeEmployee(inst_employee.getId());
            listEmployeesPerson.add(inst_employee);

            System.out.println("\n========================================");
            System.out.println("Empleado actualizado...");
            inst_employee.getEmployee(inst_employee.getId());
        }
    }

    /* FUNCIONES DE CLIENTE */
    public static void createClient(int cant) {
        for (int i = 0; i < cant; i++) {
            System.out.println(StylesInterface.ANSI_CYAN + "\n****** CLIENTE " + (i + 1) + "******" + StylesInterface.ANSI_RESET);

            System.out.println(StylesInterface.ANSI_PURPLE + "Número de documento:" + StylesInterface.ANSI_RESET);
            int id_client = Integer.parseInt(inst_input_data.nextLine());

            System.out.println(StylesInterface.ANSI_PURPLE + "Nombre cliente:" + StylesInterface.ANSI_RESET);
            String name_client = inst_input_data.nextLine();

            System.out.println(StylesInterface.ANSI_PURPLE + "Apellido cliente:" + StylesInterface.ANSI_RESET);
            String last_name_cliente = inst_input_data.nextLine();

            System.out.println(StylesInterface.ANSI_PURPLE + "Correo electronico:" + StylesInterface.ANSI_RESET);
            String email_client = inst_input_data.nextLine();

            ClientPersonClass inst_client = new ClientPersonClass(name_client, last_name_cliente, id_client, email_client);
            listClientsPerson.add(inst_client);
        }
    }

    public static void listClients(int cant) {
        for (int i = 0; i < cant; i++) {
            ClientPersonClass inst_client = (ClientPersonClass) listClientsPerson.get(i);
            System.out.println(inst_client.getClient(inst_client.getId()));
        }
    }

    public static void removeClient(int id_client) {
        for (int i = 0; i < listEmployeesPerson.size(); i++) {
            ClientPersonClass client = (ClientPersonClass) listEmployeesPerson.get(i);
            if (client.getId() == id_client) {
                System.out.println(StylesInterface.ANSI_RED + "\nCliente eliminado" + StylesInterface.ANSI_RESET);
                System.out.println(StylesInterface.ANSI_RED + "Nro. documento: " + StylesInterface.ANSI_RESET + client.getId());
                System.out.println(StylesInterface.ANSI_RED + "Nombre: " + StylesInterface.ANSI_RESET + client.getName() + " " + client.getLast_name());

                listEmployeesPerson.remove(client);
            }
        }
    }

    public static void editClient(int index) {
        if (index >= 0 && index <= listClientsPerson.size()) {
            ClientPersonClass inst_client = (ClientPersonClass) listClientsPerson.get(index);

            inst_client.getClient(inst_client.getId());

            System.out.println("¿Deseas editar?\n\t1.Nombre.\n\t2. Documento.\n\t3. Email.");
            int option_edit = Integer.parseInt(inst_input_data.nextLine());

            System.out.println(StylesInterface.ANSI_BLUE + "Ingresa el nuevo valor: " + StylesInterface.ANSI_RESET);
            switch (option_edit) {
                case 1:
                    String new_name = inst_input_data.nextLine();
                    inst_client.setName(new_name);
                    break;
                case 2:
                    int new_id = Integer.parseInt(inst_input_data.nextLine());
                    break;
                case 3:
                    String new_email = inst_input_data.nextLine();
                    inst_client.setEmail(new_email);
                    break;
                default:
                    break;
            }

            removeEmployee(inst_client.getId());
            listClientsPerson.add(inst_client);

            System.out.println("\n========================================");
            System.out.println("Cliente actualizado...");
            inst_client.getClient(inst_client.getId());
        }
    }

    public static void main(String[] args) {
        createPosition();

        System.out.println("\nDesea añadir:\n1. Empleados. \n2. Clientes.");
        int add_person_type = Integer.parseInt(inst_input_data.nextLine());

        System.out.println("Cantidad de personas a añadir: ");
        int cant_persons_add = Integer.parseInt(inst_input_data.nextLine());

        if (add_person_type == 1) {
            createEmployees(cant_persons_add);
            
            createAdmin();

            System.out.println("\n¿Qué más deseas hacer?\n1. Listar empleados.\n2. Editar un empleado.\n3. Eliminar un empleado.\n4. Salir del sistema.");
            int opcion_intermedia = Integer.parseInt(inst_input_data.nextLine());

            int quantityEmployees = listEmployeesPerson.size();

            switch (opcion_intermedia) {
                case 1:
                    listEmployees(quantityEmployees);
                    break;
                case 2:
                    System.out.println("Posición empleado que deseas editar (1 - " + quantityEmployees + "): ");
                    int index_employee = Integer.parseInt(inst_input_data.nextLine()) - 1;
                    editEmployee(index_employee);
                    break;
                case 3:
                    System.out.println("Nro de documento del empleado que deseas eliminar: ");
                    int number_document = Integer.parseInt(inst_input_data.nextLine());
                    removeEmployee(number_document);
                    break;
                default:
                    break;
            }
        } else if (add_person_type == 2) {
            createClient(cant_persons_add);

            System.out.println("\n¿Qué más deseas hacer?\n1. Listar clientes.\n2. Editar un cliente.\n3. Eliminar un cliente.\n4. Salir del sistema.");
            int opcion_intermedia = Integer.parseInt(inst_input_data.nextLine());

            int quantityClients = listClientsPerson.size();
            switch (opcion_intermedia) {
                case 1:
                    listClients(quantityClients);
                    break;
                case 2:
                    System.out.println("Posición cliente que deseas editar (1 - " + quantityClients + "): ");
                    int index_client = Integer.parseInt(inst_input_data.nextLine()) - 1;
                    editClient(index_client);
                    break;
                case 3:
                    System.out.println("Nro de documento del empleado que deseas eliminar: ");
                    int number_document = Integer.parseInt(inst_input_data.nextLine());
                    removeClient(number_document);
                    break;
                default:
                    break;
            }
        }
    }

}
