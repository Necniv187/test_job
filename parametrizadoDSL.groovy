job('ejemplo2-job-DSL') {
	description("Job DSK de ejemplo para el curso jenins")
    scm{
      git('https://github.com/Necniv187/test_job.git','main'){ node ->
        node / gitConfigName('necnivvan187')
        node / gitConfigEmail('necniv.van187@gmail.com')
      }
    }
    parameters{
      stringParam('nombre', defaultValue = 'Vincen', description = 'Parametro cadena para el Job Parametrizado')
      choiceParam('planeta',['Saturno','Neptuno','Marte','Jupiter','Urano'])
      booleanParam('agente', true)
    }
    triggers{
      cron('H/7 * * * *')
    }
    steps{
      shell("bash jobscript.sh")
    }
    publishers{
      mailer("go.solid.dev@gmail.com", true, true)
    }
}
