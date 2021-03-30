import { Component, Input, OnInit, Output } from "@angular/core";
import { Observable } from "rxjs";
import { NgbCarouselConfig } from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: "app-slider",
  template: ` <ngb-carousel *ngIf="true" [showNavigationArrows]="showNavigationArrows">
    <ng-template ngbSlide *ngFor="let producto of productos | async">
      <div class="picsum-img-wrapper" (click)="onClick($event,producto.nombre)" >
        <img [src]="producto.imagen" alt="Random slide" />
        <div class="carousel-caption">
          <div class="container texto-imagen">
            <div class="row">
            <h4>{{ producto.nombre }}</h4>
            </div>
            <div class="row">
              <p>{{ producto.descripcion }}</p>
            </div>
          </div>
        </div>
      </div>
    </ng-template>
  </ngb-carousel>`,
  styleUrls: ["./slider.component.css"],
  providers: [NgbCarouselConfig],
})
export class SliderComponent implements OnInit {
  @Input()
  productos!: Observable<any>;
  @Output()
  elegido!: String;

  showNavigationArrows = true;
  constructor(config: NgbCarouselConfig) {
    // customize default values of carousels used by this component tree
    config.showNavigationArrows = true;
    config.showNavigationIndicators = false;
    config.wrap = false;
    config.keyboard = true;
    config.pauseOnHover = false;
  }

  ngOnInit(): void {
    
  }

  onClick(event: any,nombre: String){
    var target = event.target || event.srcElement || event.currentTarget;
    this.elegido = target.attributes.id;
    console.log(nombre);
  }
}
