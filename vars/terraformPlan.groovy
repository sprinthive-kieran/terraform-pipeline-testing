#!/usr/bin/groovy

/**
 * @param config.environments: JSON Array of environments to plan
 * @return
 */
def call(config) {
        stage('Check Plans') {
            steps {
                script {
                      for (env in config.environments) {
                        stage("Terraform Plan: $env.name") {
                             sh "pwd"
                              echo "$env.name"
                              dir("envs/$env.name/") {
                                sh "terraform init"
                                sh "pwd"
                                  if (env.workspace != "default") {
                                      sh "terraform workspace select $env.workspace"
                                  }

                                sh "terraform plan -out ../../plans/$env.name-plan"
                              }

                        }
                      }
                }
            }
        }

}