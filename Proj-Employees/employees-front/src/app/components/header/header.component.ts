import { Component, AfterViewInit, ViewChild, ElementRef  } from '@angular/core';
import lottie from 'lottie-web';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [MatButtonModule, MatToolbarModule],
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements AfterViewInit {

  @ViewChild('lottieContainer', { static: false }) lottieContainer!: ElementRef;

  ngAfterViewInit(): void {
    lottie.loadAnimation({
      container: this.lottieContainer.nativeElement, // Elemento contenedor
      renderer: 'svg',       // Utiliza el renderizador SVG
      loop: true,            // Repetición de la animación
      autoplay: true,        // Comienza a reproducirse automáticamente
      path: 'assets/Staff.json' // Ruta del archivo JSON exportado
    });
  }
}
