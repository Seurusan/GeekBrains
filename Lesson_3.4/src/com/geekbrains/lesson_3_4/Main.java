package com.geekbrains.lesson_3_4;

public class Main {

    public static void main(String[] args) {

        ThreadTask.startThreads();

        /**
         * 2. На серверной стороне сетевого чата реализовать управление потоками через ExecutorService.
         */

        /**
         * Возможная реализация потоков через Executor, которая могла бы быть актуальна в случае с чатом -
         * это выделение 4-ых фиксированных потоков:
         * ExecutorService service = Executors.newFixedThreadPool(4);
         * т.к. в базе данных у нас всего четыре пользователя и лишние
         * возможные потоки нам ни к чему.
         *
         * Можно добавить проверку на наличие активных пользователей и в
         * случае отсутствия таковых, выполнять команду:
         * service.shutdown();
         * так как функция disconnect() этого не предусматривает
         *
         */

//        ExecutorService service = Executors.newFixedThreadPool(4);
//
//        service.execute(() -> {
//            try {

//                //Общение с клиентом
//                while (true) {
//                    String msg = in.readUTF();
//                    if (msg.startsWith("/")) {
//                        executeCommand(msg);
//                        continue;
//                    }

//                    //Запрос никнейма
//                    if (msg.startsWith("/who_am_i")) {
//                        sendMessage("Your nickname is: " + username + "\n");
//                        continue;
//                    } else {
//                        server.broadcastMessage(username + " : " + msg);
//                    }
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                disconnect();
//            }
//        }).start();
//

    }
}
