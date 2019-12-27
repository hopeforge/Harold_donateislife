import {Component, OnDestroy} from '@angular/core';
import { NbThemeService } from '@nebular/theme';
import { takeWhile } from 'rxjs/operators' ;
import { SolarData } from '../../@core/data/solar';
import * as CanvasJS from '../../../assets/js/canvasjs.min.js';
import { DashboardService } from '../../../dashboard.service';

interface CardSettings {
  title: string;
  iconClass: string;
  type: string;
}

@Component({
  selector: 'ngx-dashboard',
  styleUrls: ['./dashboard.component.scss'],
  templateUrl: './dashboard.component.html',
})
export class DashboardComponent implements OnDestroy {

  private alive = true;

  constructor(private themeService: NbThemeService,
    private solarService: SolarData,
    private dashboardService: DashboardService) {
      this.themeService.getJsTheme()
      .pipe(takeWhile(() => this.alive))
      .subscribe(theme => {
      console.log(theme);
      });

    }

  ngOnInit(): void {
    this.dashboardService.get1().subscribe((result: []) => {
      let data = [];
      result.forEach(item => {
        let obj = {'y':item['valor'], 'label': item['ano']};
        data.push(obj)
      })
      let chart = new CanvasJS.Chart("chartContainer2", {
        animationEnabled: true,
        exportEnabled: false,
        title: {
          text: "Valor de Doações Por Ano"
        },
        data: [{
          type: "column",
          dataPoints: data
        }]
      });
        
      chart.render();
    })

    this.dashboardService.get2().subscribe((result: []) => {
      console.log(result)
      let data = [];
      result.forEach(item => {
        let obj = {'y':item['qnt'], 'label': item['tipo']};
        data.push(obj)
      })
      let chart2 = new CanvasJS.Chart("chartContainer", {
        theme: "light1",
        animationEnabled: true,
        exportEnabled: false,
        title:{
          text: "Perfis de Doadores"
        },
        data: [{
          type: "pie",
          showInLegend: true,
          dataPoints: data
        }]
      });
      chart2.render();
    })
  }

  ngOnDestroy() {
    this.alive = false;
  }
}
