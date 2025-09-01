import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AddAccountComponent } from './add-account/add-account.component';
import { AllDetailsComponent } from './all-details/all-details.component';
import { SearchAccountComponent } from './search-account/search-account.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'add-account', component: AddAccountComponent },
  { path: 'all-details', component: AllDetailsComponent },
  { path: 'search-account', component: SearchAccountComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
