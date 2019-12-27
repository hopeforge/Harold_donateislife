import { TwitterService } from './../../../twitter.service';
import {Component, OnDestroy} from '@angular/core';
import { LocalDataSource } from 'ng2-smart-table';
import { SmartTableData } from '../../@core/data/smart-table';
import {
  NbComponentStatus,
  NbGlobalLogicalPosition,
  NbGlobalPhysicalPosition,
  NbGlobalPosition,
  NbToastrService,
} from '@nebular/theme';
import { ToasterConfig } from 'angular2-toaster';

@Component({
  selector: 'ngx-dashboard',
  styleUrls: ['./twitter.component.scss'],
  templateUrl: './twitter.component.html',
})
export class TwitterComponent implements OnDestroy {

  

  constructor(
    public twitterService: TwitterService,
    private toastrService: NbToastrService
  ) {}


  config: ToasterConfig;

  index = 1;
  destroyByClick = true;
  duration = 2000;
  hasIcon = true;
  position: NbGlobalPosition = NbGlobalPhysicalPosition.TOP_RIGHT;
  preventDuplicates = false;
  status: NbComponentStatus = 'success';

  title = 'Sucesso';
  content = `Directs foram enviados a todos usuários!`;

  types: NbComponentStatus[] = [
    'primary',
    'success',
    'info',
    'warning',
    'danger',
  ];
  positions: string[] = [
    NbGlobalPhysicalPosition.TOP_RIGHT,
    NbGlobalPhysicalPosition.TOP_LEFT,
    NbGlobalPhysicalPosition.BOTTOM_LEFT,
    NbGlobalPhysicalPosition.BOTTOM_RIGHT,
    NbGlobalLogicalPosition.TOP_END,
    NbGlobalLogicalPosition.TOP_START,
    NbGlobalLogicalPosition.BOTTOM_END,
    NbGlobalLogicalPosition.BOTTOM_START,
  ];

  quotes = [
    { title: null, body: 'We rock at Angular' },
    { title: null, body: 'Titles are not always needed' },
    { title: null, body: 'Toastr rock!' },
  ];

  makeToast() {
    this.showToast(this.status, this.title, this.content);
  }

  openRandomToast () {
    const typeIndex = Math.floor(Math.random() * this.types.length);
    const quoteIndex = Math.floor(Math.random() * this.quotes.length);
    const type = this.types[typeIndex];
    const quote = this.quotes[quoteIndex];

    this.showToast(type, quote.title, quote.body);
  }

  private showToast(type: NbComponentStatus, title: string, body: string) {
    const config = {
      status: type,
      destroyByClick: this.destroyByClick,
      duration: this.duration,
      hasIcon: this.hasIcon,
      position: this.position,
      preventDuplicates: this.preventDuplicates,
    };
    const titleContent = title ? ` ${title}` : '';

    this.index += 1;
    this.toastrService.show(
      body,
      titleContent,
      config);
  }

  public isResult = false;
  public settings = {
    actions: false,
    columns: {
      user_id: {
        title: 'ID',
        type: 'number',
      },
      screen_name: {
        title: 'Nome',
        type: 'string',
      },
      user_name: {
        title: 'Username',
        type: 'string',
      },
      user_location: {
        title: 'Local',
        type: 'string',
      },
      friends_count: {
        title: 'Qtd. Amigos',
        type: 'number',
      },
      followers_count: {
        title: 'Qtd. Seguidores',
        type: 'number',
      },
      probability: {
        title: 'Índice',
        type: 'number',
      },
    },
  }

  private alive = true;
  public message = '';
  public result:any = [];

  source: LocalDataSource = new LocalDataSource();

  ngOnInit(): void {
  }
  ngOnDestroy() {
    this.alive = false;
  }

  buscarHash() {
    if(this.message != '') {
      this.twitterService.getTwittes(this.message).subscribe(resultado =>{
        this.result = resultado;
        this.source.load(this.result);
        this.isResult = true;
      })    
    }
  }

  onDeleteConfirm(event): void {
    if (window.confirm('Deseja excluir?')) {
      event.confirm.resolve();
    } else {
      event.confirm.reject();
    }
  }

  hasResult() {
    return this.result.length > 0;
  }

  sendDirect() {
    this.makeToast();
  }
}
