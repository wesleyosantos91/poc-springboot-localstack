#!/bin/bash

echo "########### Starting ###########"

hostname=http://localhost:4566

echo "########### Deploy the stack CloudFormation ###########"

cd /configs/cloudformation/resources

for file in `ls | sort -V`
do
    echo $file
    if [[ -f $file ]]; then
        aws cloudformation deploy --stack-name ${file%.*} --template-file $file --endpoint-url $hostname --profile localstack --region us-east-1
    fi
done

echo "########### Validation creates resources ###########"

# aws s3api list-buckets --endpoint-url $hostname --profile localstack --region us-east-1
aws --endpoint http://localhost:4566 --profile localstack ssm get-parameter --name "/config/spring-boot-localstack_localstack/helloWorld" --region us-east-1
aws --endpoint http://localhost:4566 --profile localstack secretsmanager describe-secret --secret-id "/secret/spring-boot-localstack_localstack" --region us-east-1
aws --endpoint http://localhost:4566 --profile localstack secretsmanager create-secret --name /secret/bff-marvel-api_localstack --description "Segredos para acesso a API da Marvel" --secret-string "{\"ts\":\"1\",\"apiKey\":\"f59dbe01285f1d360542b5c47a9516e3\",\"hash\":\"0ea6be79e04ac1b0400d65ffc11088f9\"}"
aws --endpoint http://localhost:4566 --profile localstack secretsmanager create-secret --name /secret/spring-boot-localstack --description "Exemplo de Secrets Manager" --secret-string "{\"valor1\":\"Oi Mundo\",\"valor2\":\"Hello World\",\"valor3\":\"Hola Mundo\"}"


