# HamburgueriaZ 🍔

Um aplicativo Android simples e intuitivo para realizar pedidos de hambúrgueres personalizados. O projeto foi desenvolvido como um exercício prático de desenvolvimento mobile, focando em manipulação de componentes de UI, lógica de cálculo e uso de Intents.

## 🚀 Funcionalidades

- **Personalização de Pedido:** Escolha de adicionais como Bacon, Queijo e Onion Rings.
- **Controle de Quantidade:** Botões interativos para aumentar ou diminuir a quantidade de itens.
- **Cálculo em Tempo Real:** O valor total é atualizado instantaneamente conforme as opções são selecionadas.
- **Resumo do Pedido:** Exibição de um resumo detalhado com o nome do cliente e especificações do hambúrguer.
- **Integração com E-mail:** Envio automático dos dados do pedido para o estabelecimento via Intent de e-mail.

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java
- **Plataforma:** Android SDK
- **Layout:** XML (ConstraintLayout)
- **Componentes:** AppCompatActivity, Intents, View Binding manual (findViewById).

## 📱 Como usar

1. Insira o nome do cliente no campo de texto.
2. Selecione os adicionais desejados (Bacon, Queijo, Onion Rings).
3. Defina a quantidade de hambúrgueres usando os botões `+` e `-`.
4. Clique em **Fazer Pedido** para gerar o resumo.
5. O aplicativo abrirá seu cliente de e-mail padrão com os dados prontos para envio.

## 📐 Estrutura de Preços

| Item | Valor (R$) |
| :--- | :--- |
| Hambúrguer Base | 20.00 |
| Adicional de Bacon | 2.00 |
| Adicional de Queijo | 2.00 |
| Adicional de Onion Rings | 3.00 |

---
Desenvolvido por Rodrigo Almeida.