package Exercise1.Behavioural.ChainofResponsibilityPattern;


abstract class Approver {
    protected Approver nextApprover;

    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    public abstract void approveDocument(int confidentialityLevel);
}

class Manager extends Approver {
    public void approveDocument(int confidentialityLevel) {
        if (confidentialityLevel <= 1) {
            System.out.println("Manager approved the document.");
        } else if (nextApprover != null) {
            nextApprover.approveDocument(confidentialityLevel);
        }
    }
}

class Director extends Approver {
    public void approveDocument(int confidentialityLevel) {
        if (confidentialityLevel <= 2) {
            System.out.println("Director approved the document.");
        } else if (nextApprover != null) {
            nextApprover.approveDocument(confidentialityLevel);
        }
    }
}

class CEO extends Approver {
    public void approveDocument(int confidentialityLevel) {
        if (confidentialityLevel <= 3) {
            System.out.println("CEO approved the document.");
        } else {
            System.out.println("Document approval failed, too confidential.");
        }
    }
}

// Main
public class DocumentApprovalSystem {
    public static void main(String[] args) {
        Approver manager = new Manager();
        Approver director = new Director();
        Approver ceo = new CEO();
        
        manager.setNextApprover(director);
        director.setNextApprover(ceo);

        manager.approveDocument(2); // Director will approve
        manager.approveDocument(3); // CEO will approve
    }
}

