#!/usr/bin/groovy

/**
 * @param config.environment: The environment being planned
 * @param config.workspace: The Terraform workspace this environment lives in
 * @return
 */
def call(config) {
        stage('Check Plans') {
            steps {
                script {
                      for (env in config.envsJson) {
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