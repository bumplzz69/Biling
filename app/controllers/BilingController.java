package controllers;

import models.Biling;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import services.BilingService;
import views.html.invoice;
import views.html.listInvoice;

public class BilingController extends Controller {

    static Form<Biling> bilingForm = Form.form(Biling.class);

    public static Result bilins() {
	return ok(listInvoice.render(Biling.all()));
    }

    public static Result newBiling() {
	Form<Biling> biling = bilingForm.bindFromRequest();
	/*
	 * if has errors
	 */
	if (biling.hasErrors()) {
	    return badRequest(invoice.render(bilingForm));
	}

	BilingService.create(biling.get());
	return ok(invoice.render(bilingForm));
    }

    public static Result editBiling(Long id) {
	Biling bill = BilingService.get(id);
	bilingForm.fill(bill);
	return ok(invoice.render(bilingForm));
    }

    public static Result deleteBiling(Long id) {
	BilingService.delete(id);
	return ok(listInvoice.render(Biling.all()));
    }
}
