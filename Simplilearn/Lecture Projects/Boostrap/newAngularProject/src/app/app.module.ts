import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FirstcmpComponent } from './firstcmp/firstcmp.component';
import { SecondcmpComponent } from './secondcmp/secondcmp.component';
import { InterpolationcmpComponent } from './interpolationcmp/interpolationcmp.component';
import { PropertybindingComponent } from './propertybinding/propertybinding.component';
import { EventHandlingComponentComponent } from './event-handling-component/event-handling-component.component';
import { TwowaydatabindingComponent } from './twowaydatabinding/twowaydatabinding.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DirectivesComponent } from './directives/directives.component';
import { PipedemocomponentComponent } from './pipedemocomponent/pipedemocomponent.component';
import { ParentComponentComponent } from './parent-component/parent-component.component';
import { ChildComponentComponent } from './child-component/child-component.component';
import { Child2ComponentComponent } from './child2-component/child2-component.component';
import { Parent2ComponentComponent } from './parent2-component/parent2-component.component';
import { EmplistComponent } from './emplist/emplist.component';
import { HttpClientModule } from '@angular/common/http';
import { EmphttpComponent } from './emphttp/emphttp.component';
import { TemplatedrivenformComponent } from './templatedrivenform/templatedrivenform.component';
import { ReactiveformsComponent } from './reactiveforms/reactiveforms.component';
import { HomeComponent } from './home/home.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { RoutingComponent } from './routing/routing.component';
import { ContactusComponent } from './contactus/contactus.component';

@NgModule({
  declarations: [
    AppComponent,
    FirstcmpComponent,
    SecondcmpComponent,
    InterpolationcmpComponent,
    PropertybindingComponent,
    EventHandlingComponentComponent,
    TwowaydatabindingComponent,
    DirectivesComponent,
    PipedemocomponentComponent,
    ParentComponentComponent,
    ChildComponentComponent,
    Child2ComponentComponent,
    Parent2ComponentComponent,
    EmplistComponent,
    EmphttpComponent,
    TemplatedrivenformComponent,
    ReactiveformsComponent,
    HomeComponent,
    AboutusComponent,
    RoutingComponent,
    ContactusComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
