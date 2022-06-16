package bg.softUni.mobilele.web;

import bg.softUni.mobilele.model.dto.AddOfferDto;
import bg.softUni.mobilele.service.BrandService;
import bg.softUni.mobilele.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;
    private final BrandService brandService;

    public OfferController(OfferService offerService, BrandService brandService) {

        this.offerService = offerService;
        this.brandService = brandService;
    }


    @GetMapping("/all")
    public String addOffers(){
        return "offers";
    }

    @GetMapping("/add")
    public String addOffer(Model model)
    {
        if(!model.containsAttribute("addOfferDto")){
            model.addAttribute("addOfferDto", new AddOfferDto());
        }

        model.addAttribute("brands", brandService.getAllBrands());

        return "offer-add";
    }


    @PostMapping("/add")
    public String addOffer(@Valid AddOfferDto addOfferDto,BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("addOfferDto",addOfferDto);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.addOfferDto",
                    bindingResult);

            System.out.println();
            return "redirect:/offers/add";
        }

        offerService.addOffer(addOfferDto);

        return "redirect:/offers/all";
    }

}
