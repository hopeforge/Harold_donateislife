import { PerfilService } from './../../../perfi.service';
import {Component, OnDestroy} from '@angular/core';
import { NbThemeService } from '@nebular/theme';
import { takeWhile } from 'rxjs/operators' ;
import { SolarData } from '../../@core/data/solar';
import { LocalDataSource } from 'ng2-smart-table';

interface CardSettings {
  title: string;
  iconClass: string;
  type: string;
}

@Component({
  selector: 'ngx-dashboard',
  styleUrls: ['./canais.component.scss'],
  templateUrl: './canais.component.html',
})
export class CanaisComponent implements OnDestroy {

  private alive = true;
  public resultado = [];

  ngOnInit(): void {
    this.getResult();
  }

  ngOnDestroy() {
    this.alive = false;
  }

  public settings = {
    actions: false,
    columns: {
      id: {
        title: 'ID',
        type: 'number',
      },
      sexo: {
        title: 'Sexo',
        type: 'string',
      },
      idade: {
        title: 'Idade',
        type: 'string',
      },
      uf: {
        title: 'UF',
        type: 'string',
      }
    },
  }

  source: LocalDataSource = new LocalDataSource();

  constructor(private themeService: NbThemeService,
    private perfilService: PerfilService) {
      this.themeService.getJsTheme()
      .pipe(takeWhile(() => this.alive))
      .subscribe(theme => {
      console.log(theme);
      });

    }

  hasResult() {
    return this.resultado.length > 0;
  }

  getResult() {
      this.perfilService.getUsers().subscribe((resultado: []) =>{
        console.log(resultado);
        this.resultado = resultado;
        this.source.load(this.resultado);
      })    
  }

  onDeleteConfirm(event): void {
    if (window.confirm('Deseja excluir?')) {
      event.confirm.resolve();
    } else {
      event.confirm.reject();
    }
  }
}
