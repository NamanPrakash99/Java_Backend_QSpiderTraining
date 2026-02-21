package com.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CRMMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CustomerService customerService = new CustomerService();
        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();
        LeadService leadService = new LeadService();
        SalesEmployeeService employeeService = new SalesEmployeeService();
        TicketService ticketService = new TicketService();

        while (true) {

            System.out.println("\n===== CRM MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Customer");
            System.out.println("2. Create Product");
            System.out.println("3. Create Sales Employee");
            System.out.println("4. Create Lead");
            System.out.println("5. Assign Lead to Employee");
            System.out.println("6. Convert Lead to Customer");
            System.out.println("7. Place Order");
            System.out.println("8. Create Support Ticket");
            System.out.println("9. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String cname = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String cemail = sc.nextLine();
                    System.out.print("Enter Phone: ");
                    String cphone = sc.nextLine();

                    customerService.registerCustomer(cname, cemail, cphone);
                    break;

                case 2:
                    sc.nextLine();
                    System.out.print("Enter Product Name: ");
                    String pname = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    productService.createProduct(pname, price);
                    break;

                case 3:
                    sc.nextLine();
                    System.out.print("Enter Employee Name: ");
                    String ename = sc.nextLine();
                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();

                    employeeService.createEmployee(ename, dept);
                    break;

                case 4:
                    sc.nextLine();
                    System.out.print("Enter Lead Source: ");
                    String source = sc.nextLine();
                    System.out.print("Enter Lead Status: ");
                    String status = sc.nextLine();

                    leadService.createLead(source, status);
                    break;

                case 5:
                    System.out.print("Enter Lead ID: ");
                    int leadId = sc.nextInt();
                    System.out.print("Enter Employee ID: ");
                    int empId = sc.nextInt();

                    leadService.assignLead(leadId, empId);
                    break;

                case 6:
                    System.out.print("Enter Lead ID to Convert: ");
                    int convertId = sc.nextInt();

                    leadService.convertLeadToCustomer(convertId);
                    break;

                case 7:
                    System.out.print("Enter Customer ID: ");
                    int custId = sc.nextInt();

                    System.out.print("How many products? ");
                    int n = sc.nextInt();

                    List<Integer> productIds = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        System.out.print("Enter Product ID: ");
                        productIds.add(sc.nextInt());
                    }

                    orderService.placeOrder(custId, productIds);
                    break;

                case 8:
                    System.out.print("Enter Product ID: ");
                    int productId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Issue: ");
                    String issue = sc.nextLine();

                    ticketService.createTicket(productId, issue);
                    break;

                case 9:
                    System.out.println("Exiting CRM Application...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
}