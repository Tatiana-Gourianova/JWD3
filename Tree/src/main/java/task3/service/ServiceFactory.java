package task3.service;


import task3.service.impl.MenueServiceImpl;

public final class ServiceFactory {
        private static final ServiceFactory instance = new ServiceFactory();

        private final MenueService menueService = new MenueService();

        private ServiceFactory() {}

        public MenueService getMenueService() {

            return menueService;
        }

        public static ServiceFactory getInstance() {
            return instance;
        }

    }


