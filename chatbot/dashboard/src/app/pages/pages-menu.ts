import { NbMenuItem } from '@nebular/theme';

export const MENU_ITEMS: NbMenuItem[] = [
  {
    title: 'Dashboard',
    icon: 'home-outline',
    link: '/pages/dashboard',
    home: true,
  },
  {
    title: 'Mari (ChatBot)',
    icon: 'heart',
    link: '/pages/bot'
  },

    {
      title: 'Busca Mantenedores',
      icon: 'hash',
      link: '/pages/twitter',
    },
  {
    title: 'Perfil Certo - Risco',
    icon: 'funnel-outline',
    link: '/pages/canais',
  },
];
