import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'region',
        loadChildren: './region/region.module#TestProjectRegionModule'
      },
      {
        path: 'country',
        loadChildren: './country/country.module#TestProjectCountryModule'
      },
      {
        path: 'location',
        loadChildren: './location/location.module#TestProjectLocationModule'
      },
      {
        path: 'department',
        loadChildren: './department/department.module#TestProjectDepartmentModule'
      },
      {
        path: 'task',
        loadChildren: './task/task.module#TestProjectTaskModule'
      },
      {
        path: 'employee',
        loadChildren: './employee/employee.module#TestProjectEmployeeModule'
      },
      {
        path: 'job',
        loadChildren: './job/job.module#TestProjectJobModule'
      },
      {
        path: 'job-history',
        loadChildren: './job-history/job-history.module#TestProjectJobHistoryModule'
      }
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ])
  ],
  declarations: [],
  entryComponents: [],
  providers: [],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class TestProjectEntityModule {}
