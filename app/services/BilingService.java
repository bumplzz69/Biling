package services;

import models.Biling;

public class BilingService {

    public static void create(Biling biling) {
	Biling.create(biling);
    }

    public static Biling get(Long id) {
	return Biling.get(id);
    }

    public static void delete(Long id) {
	Biling.delete(id);
    }

}
