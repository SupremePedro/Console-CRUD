import com.pedrofactory.controller.AccountController;
import com.pedrofactory.controller.DeveloperController;
import com.pedrofactory.controller.MainController;
import com.pedrofactory.controller.SkillController;
import com.pedrofactory.repository.AccountRepository;
import com.pedrofactory.repository.DeveloperRepository;
import com.pedrofactory.repository.SkillRepository;
import com.pedrofactory.repository.impl.JavaIOAccountRepository;
import com.pedrofactory.repository.impl.JavaIODeveloperRepositoryImpl;
import com.pedrofactory.repository.impl.JavaIOSkillRepositoryImpl;
import com.pedrofactory.view.AccountView;
import com.pedrofactory.view.DeveloperView;
import com.pedrofactory.view.MainView;
import com.pedrofactory.view.SkillView;

public class Runner {
    public static void main(String[] args) throws Exception {
        MainController mainController = new MainController();
        AccountController accountController = new AccountController();
        SkillController skillController = new SkillController();
        DeveloperController developerController =  new DeveloperController();
        MainView mainView = new MainView();
        AccountView accountView = new AccountView();
        SkillView skillView = new SkillView();
        DeveloperView developerView = new DeveloperView();
        DeveloperRepository developerRepository = new JavaIODeveloperRepositoryImpl();
        AccountRepository accountRepository = new JavaIOAccountRepository();
        SkillRepository skillRepository = new JavaIOSkillRepositoryImpl();

        mainController.setAccountController(accountController);
        mainController.setDeveloperController(developerController);
        mainController.setSkillController(skillController);
        mainController.setMainView(mainView);

        mainView.setMainController(mainController);

        developerController.setView(developerView);
        developerController.setDeveloperRepository(developerRepository);
        developerController.setMainController(mainController);
        developerController.setAccountRepository(accountRepository);
        developerController.setSkillRepository(skillRepository);

        developerView.setDeveloperController(developerController);

        accountController.setMainController(mainController);
        accountController.setAccountRepository(accountRepository);
        accountController.setAccountView(accountView);

        accountView.setAccountController(accountController);

        skillController.setMainController(mainController);
        skillController.setSkillView(skillView);
        skillController.setSkillRepository(skillRepository);

        skillView.setSkillController(skillController);
        mainView.start();
        System.out.println("Wrong command, force exit!!!");
    }
}
