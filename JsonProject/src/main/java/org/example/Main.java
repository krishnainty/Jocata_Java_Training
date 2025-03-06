package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entity.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        ObjectMapper objectMapper = new ObjectMapper();
        try {

            LoanEcosystemWrapper wrapper = objectMapper.readValue(new File("src/main/resources/data.json"), LoanEcosystemWrapper.class);
            LoanEcosystem loanEcosystem = wrapper.getLoanEcosystem();


            saveToDatabase(loanEcosystem);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveToDatabase(LoanEcosystem loanEcosystem) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            org.hibernate.Transaction transaction = session.beginTransaction();


            session.persist(loanEcosystem);
            session.flush();

            for (Institution institution : loanEcosystem.getInstitutions()) {
                institution.setEcosystem(loanEcosystem);
                session.persist(institution);
                session.flush();

                for (Branch branch : institution.getBranches()) {
                    branch.setInstitution(institution);
                    session.persist(branch);
                    session.flush();

                    for (Manager manager : branch.getManagers()) {
                        manager.setBranch(branch);
                        session.persist(manager);
                    }

                    for (LoanApplication loanApp : branch.getLoanApplications()) {
                        loanApp.setBranch(branch);
                        session.persist(loanApp);
                        session.flush();


                        for (org.example.entity.Transaction txn : loanApp.getTransactions()) {
                            txn.setLoanApplication(loanApp);
                            session.persist(txn);
                        }


                        Applicant applicant = loanApp.getApplicant();
                        if (applicant != null) {
                            applicant.setLoanApplication(loanApp);
                            session.persist(applicant);
                            session.flush();

                            PersonalDetails personalDetails = applicant.getPersonalDetails();
                            if (personalDetails != null) {
                                personalDetails.setApplicant(applicant);
                                session.persist(personalDetails);
                                session.flush();

                                ContactDetails contactDetails = personalDetails.getContactDetails();
                                if (contactDetails != null) {
                                    contactDetails.setPersonalDetails(personalDetails);
                                    session.persist(contactDetails);
                                }

                                for (Address address : contactDetails.getAddresses()) {
                                    address.setContactDetails(contactDetails);
                                    session.persist(address);
                                }
                            }

                            EmploymentDetails employment = applicant.getEmploymentDetails();
                            if (employment != null) {
                                employment.setApplicant(applicant);
                                session.persist(employment);
                            }
                        }

                        LoanDetails loanDetails = loanApp.getLoanDetails();
                        if (loanDetails != null) {
                            loanDetails.setLoanApplication(loanApp);
                            session.persist(loanDetails);
                            session.flush();

                            for (RepaymentSchedule repayment : loanDetails.getRepaymentSchedule()) {
                                repayment.setLoanDetails(loanDetails);
                                session.persist(repayment);
                            }
                        }

                        for (Collateral collateral : loanApp.getCollateral()) {
                            collateral.setLoanApplication(loanApp);
                            session.persist(collateral);
                        }

                        RiskAssessment riskAssessment = loanApp.getRiskAssessment();
                        if (riskAssessment != null) {
                            riskAssessment.setLoanApplication(loanApp);
                            session.persist(riskAssessment);
                            session.flush();
                            for (Flag flag : riskAssessment.getFlags()) {
                                flag.setRiskAssessment(riskAssessment);
                                session.persist(flag);
                            }
                        }

                        RegulatoryCompliance compliance = loanApp.getRegulatoryCompliance();
                        if (compliance != null) {
                            compliance.setLoanApplication(loanApp);
                            session.persist(compliance);
                        }
                    }
                }
            }

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                session.beginTransaction().rollback();
            } catch (Exception rollbackEx) {
                rollbackEx.printStackTrace();
            }
        }
    }
}